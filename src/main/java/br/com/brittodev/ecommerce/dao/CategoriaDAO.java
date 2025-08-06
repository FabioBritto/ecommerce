package br.com.brittodev.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.brittodev.ecommerce.model.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer>{
	
	public List<Categoria> findAllByOrderByNomeCategoriaAsc();
	public List<Categoria> findAllByNomeCategoria(String nome);

}
