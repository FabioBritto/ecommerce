package br.com.brittodev.ecommerce.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.brittodev.ecommerce.dao.ProdutoDAO;
import br.com.brittodev.ecommerce.model.Categoria;
import br.com.brittodev.ecommerce.model.Produto;

@Component
public class ProdutoServiceImpl implements IProdutoService {
	
	private final static int PAGE_SIZE = 5;
	
	@Autowired
	private ProdutoDAO produtoDAO;

	@Override
	public Produto createProduto(Produto produto) {
		return produtoDAO.save(produto);
	}

	@Override
	public Produto updateProduto(Produto produto) {
		return produtoDAO.save(produto);
	}
	
	@Override
	public Produto findById(Integer id) {
		return produtoDAO.findById(id).get();
	}

	@Override
	public Page<Produto> findAll(int numPagina) {
		Pageable config = PageRequest.of(numPagina, PAGE_SIZE);
		return produtoDAO.findAll(config);
		
	}

	@Override
	public List<Produto> findByNomeProdutoContaining(String palavra) {
		return produtoDAO.findByNomeProdutoContaining(palavra);
	}

	@Override
	public Page<Produto> findByOrderByNomeProdutoAsc(int numPagina) {
		Pageable config = PageRequest.of(numPagina, PAGE_SIZE);
		return produtoDAO.findByOrderByNomeProdutoAsc(config);
	}
	
	@Override
	public List<Produto> findByCategoria(Categoria categoria) {
		return produtoDAO.findByCategoriasContaining(categoria);
	}

}
