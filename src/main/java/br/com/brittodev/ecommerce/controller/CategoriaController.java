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

import br.com.brittodev.ecommerce.model.Categoria;
import br.com.brittodev.ecommerce.service.categoria.ICategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	private ICategoriaService service;
	
	@PostMapping("/categorias")
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.createCategoria(categoria));
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar categoria: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/categorias/{id}")
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Integer id){
		Categoria categoriaExistente = service.findCategoriaById(id);
		if(categoriaExistente != null) {
			try {
				categoria.setId(categoriaExistente.getId());
				return ResponseEntity.ok(service.updateCategora(categoria));
			} catch (Exception e) {
				System.out.println("Erro ao atualizar categoria: " + e.getMessage());
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<Categoria> findCategoriaById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(service.findCategoriaById(id));
		} catch (Exception e) {
			System.out.println("Erro ao recuperar categoria por ID :" + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/categorias/busca")
	public ResponseEntity<List<Categoria>> findAllByNome(@RequestParam(name = "nome") String nome) {
		try {
			return ResponseEntity.ok(service.findAllByNomeCategoria(nome));
		} catch (Exception e) {
			System.out.println("Erro ao recuperar categoria por Nome :" + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/categorias/ordenado")
	public ResponseEntity<List<Categoria>> findAllOrderByNomeCategoriaAsc() {
		try {
			return ResponseEntity.ok(service.findAllByOrderByNomeCategoriaAsc());
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> findAll() {
		try {
			return ResponseEntity.ok(service.findAll());
		}
		catch (Exception e){
			return ResponseEntity.notFound().build();
		}
	}
}
