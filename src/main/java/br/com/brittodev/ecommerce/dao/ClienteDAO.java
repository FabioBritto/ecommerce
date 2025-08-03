package br.com.brittodev.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.brittodev.ecommerce.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
	
	public Cliente findByTelefone(String telefone);

}
