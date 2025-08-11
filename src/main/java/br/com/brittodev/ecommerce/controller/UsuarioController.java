package br.com.brittodev.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.brittodev.ecommerce.model.Usuario;
import br.com.brittodev.ecommerce.service.usuario.IUsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
		Usuario criado = service.create(usuario);
		if(criado != null) return ResponseEntity.status(201).body(criado);
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable(name = "id") Integer id) {
		usuario.setIdUsuario(id);
		Usuario atualizado = service.update(usuario);
		if(atualizado != null) return ResponseEntity.ok(atualizado);
		return ResponseEntity.badRequest().build();
	}
}
