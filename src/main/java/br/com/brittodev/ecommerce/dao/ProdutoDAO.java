package br.com.brittodev.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brittodev.ecommerce.model.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Integer>{

	public List<Produto> findByNomeContaining(String palavra);
	public List<Produto> findByOrderByNomeAsc();
}
