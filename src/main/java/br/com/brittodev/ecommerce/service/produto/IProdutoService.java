package br.com.brittodev.ecommerce.service.produto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.brittodev.ecommerce.model.Categoria;
import br.com.brittodev.ecommerce.model.Produto;

public interface IProdutoService {

	public Produto createProduto(Produto produto);

	public Produto updateProduto(Produto produto);

	public Produto findById(Integer id);

	public Page<Produto> findAll(int numPagina);

	public List<Produto> findByNomeProdutoContaining(String palavra);

	public Page<Produto> findByOrderByNomeProdutoAsc(int numPagina);
	
	public List<Produto> findByCategoria(Categoria categoria);

}
