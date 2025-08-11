package br.com.brittodev.ecommerce.controller;

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

import br.com.brittodev.ecommerce.model.Produto;
import br.com.brittodev.ecommerce.model.VarianteProduto;
import br.com.brittodev.ecommerce.service.variante.IVarianteProdutoService;

@RestController
public class VarianteProdutoController {

	@Autowired
	private IVarianteProdutoService service;
	
	@PostMapping("/variantes")
	public ResponseEntity<VarianteProduto> create(@RequestBody VarianteProduto variante) {
		System.out.println(variante);
		VarianteProduto v = service.create(variante);
		if (v != null) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
			//return ResponseEntity.ok(v);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/variantes/{id}")
	public ResponseEntity<VarianteProduto> update(@RequestBody VarianteProduto variante, @PathVariable Integer id) {
		variante.setId(id);
		VarianteProduto v = service.update(variante);
		if (v != null) {
			return ResponseEntity.ok(v);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/variantes/{id}")
	public ResponseEntity<VarianteProduto> findById(@PathVariable Integer id) {
		if(id == null) return ResponseEntity.badRequest().build();
		VarianteProduto v = service.findById(id);
		if (v != null) {
			return ResponseEntity.ok(v);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/variantes")
	public ResponseEntity<List<VarianteProduto>> findByProduto(@RequestParam(name = "idproduto") Integer idProduto) {
		if(idProduto == null) return ResponseEntity.badRequest().build();
		Produto produto = new Produto();
		produto.setId(idProduto);
		List<VarianteProduto> variantes = service.findByProduto(produto);
		if(variantes.size() > 0) return ResponseEntity.ok(variantes);
		return ResponseEntity.notFound().build();
		
	}
}
