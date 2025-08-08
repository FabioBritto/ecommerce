package br.com.brittodev.ecommerce.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brittodev.ecommerce.dao.ProdutoDAO;
import br.com.brittodev.ecommerce.model.Categoria;
import br.com.brittodev.ecommerce.model.Produto;

@Component
public class ProdutoServiceImpl implements IProdutoService {
	
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
	public List<Produto> findAll() {
		return produtoDAO.findAll();
	}

	@Override
	public List<Produto> findByNomeProdutoContaining(String palavra) {
		return produtoDAO.findByNomeProdutoContaining(palavra);
	}

	@Override
	public List<Produto> findByOrderByNomeProdutoAsc() {
		return produtoDAO.findByOrderByNomeProdutoAsc();
	}
	
	@Override
	public List<Produto> findByCategoria(Categoria categoria) {
		return produtoDAO.findByCategoriasContaining(categoria);
	}

}
