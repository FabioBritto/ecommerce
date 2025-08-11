package br.com.brittodev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.brittodev.ecommerce.model.Pedido;
import br.com.brittodev.ecommerce.service.pedido.IPedidoService;

@RestController
public class PedidoController {

	
	@Autowired
	private IPedidoService service;
	
	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
		Pedido ped = service.create(pedido);
		if(ped != null) {
			return ResponseEntity.ok(ped);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> pedidos = service.findAll();
		if(pedidos.size() > 0) return ResponseEntity.ok(pedidos);
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
		Pedido pedido = service.findByNumero(id);
		if(pedido != null) return ResponseEntity.ok(pedido);
		return ResponseEntity.notFound().build();
	}
}
