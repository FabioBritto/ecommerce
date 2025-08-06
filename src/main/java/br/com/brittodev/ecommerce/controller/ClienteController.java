package br.com.brittodev.ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brittodev.ecommerce.model.Cliente;
import br.com.brittodev.ecommerce.service.cliente.IClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente cliente = service.findClienteById(id);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/clientes/busca")
	public ResponseEntity<Cliente> findByTelefone(@RequestParam(name = "telefone") String telefone) {
		Cliente cliente = service.findClienteByTelefone(telefone);
		System.out.println(cliente);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("clientes/{id}")
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Integer id) {
		cliente.setId(id);
		try {
			Cliente resultado = service.updateCliente(cliente);
			if (resultado != null) return ResponseEntity.ok(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = null;
		try{
			clienteCadastrado = service.createCliente(cliente);		
 		}
		catch (Exception e) {
			System.out.println("Erro ao cadastrar: " + e.getMessage());
		}
		return clienteCadastrado == null ? ResponseEntity.badRequest().build() : ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

}
