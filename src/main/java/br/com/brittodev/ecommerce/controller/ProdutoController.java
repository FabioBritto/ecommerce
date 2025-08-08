package br.com.brittodev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brittodev.ecommerce.model.Categoria;
import br.com.brittodev.ecommerce.model.Produto;
import br.com.brittodev.ecommerce.service.produto.IProdutoService;

@RestController
public class ProdutoController {

	// CONTINUAR IMPLEMENTAÇÃO //

	@Autowired
	private IProdutoService service;

	@PostMapping("/produtos")
	public ResponseEntity<Produto> create(@RequestBody Produto produto) {
		try {
			return ResponseEntity.ok(service.createProduto(produto));
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar Produto: " + e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable Integer id) {
		produto.setId(id);
		Produto result = service.updateProduto(produto);
		if (result != null) {
			try {
				return ResponseEntity.ok(produto);
			} catch (Exception e) {
				System.out.println("Erro ao cadastrar Produto: " + e.getMessage());
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(service.findById(id));
		} catch (Exception e) {
			System.out.println("Erro ao recuperar Produto: " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> findAll() {
		try {
			return ResponseEntity.ok(service.findAll());
		} catch (Exception e) {
			System.out.println("Erro ao recuperar Produtos: " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/produtos/busca")
	public ResponseEntity<List<Produto>> findByNomeContaining(@RequestParam(name = "palavra") String palavra) {
		if (!palavra.isEmpty() || !palavra.isBlank()) {
			List<Produto> lista = service.findByNomeProdutoContaining(palavra);
			if (lista.size() > 0) return ResponseEntity.ok(service.findByNomeProdutoContaining(palavra));
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/produtos/ordenado")
	public ResponseEntity<List<Produto>> findByOrderByNomeAsc() {
		try {
			return ResponseEntity.ok(service.findByOrderByNomeProdutoAsc());
		} catch (Exception e) {
			System.out.println("Erro ao recuperar Produtos: " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/produtos/categoria/{id}")
	public ResponseEntity<List<Produto>> findByCategoria(@PathVariable Integer id) {
		if(id != null) {
			Categoria categoria = new Categoria();
			categoria.setId(id);
			List<Produto> produtos = service.findByCategoria(categoria);
			if (produtos.size() > 0) return ResponseEntity.ok(produtos);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
