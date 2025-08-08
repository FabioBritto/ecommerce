package br.com.brittodev.ecommerce.service.produto;

import java.util.List;

import br.com.brittodev.ecommerce.model.Categoria;
import br.com.brittodev.ecommerce.model.Produto;

public interface IProdutoService {

	public Produto createProduto(Produto produto);

	public Produto updateProduto(Produto produto);

	public Produto findById(Integer id);

	public List<Produto> findAll();

	public List<Produto> findByNomeProdutoContaining(String palavra);

	public List<Produto> findByOrderByNomeProdutoAsc();
	
	public List<Produto> findByCategoria(Categoria categoria);

}
