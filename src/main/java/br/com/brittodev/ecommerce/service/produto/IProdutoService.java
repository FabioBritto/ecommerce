package br.com.brittodev.ecommerce.service.produto;

import java.util.List;

import br.com.brittodev.ecommerce.model.Produto;

public interface IProdutoService {

	public Produto createProduto(Produto produto);
	public Produto updateProduto(Produto produto);
	public List<Produto> findAll();
	//public List<Produto> find
}
