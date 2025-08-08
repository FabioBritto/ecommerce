package br.com.brittodev.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.brittodev.ecommerce.model.Produto;
import br.com.brittodev.ecommerce.model.VarianteProduto;

public interface VarianteProdutoDAO extends CrudRepository<VarianteProduto, Integer>{

	public List<VarianteProduto> findByProduto(Produto produto);
	
}
