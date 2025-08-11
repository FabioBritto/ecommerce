package br.com.brittodev.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.brittodev.ecommerce.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

	public Usuario findByLogin(String login);
}
