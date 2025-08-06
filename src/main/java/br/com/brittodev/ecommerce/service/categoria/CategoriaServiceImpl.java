package br.com.brittodev.ecommerce.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brittodev.ecommerce.dao.CategoriaDAO;
import br.com.brittodev.ecommerce.model.Categoria;

@Component
public class CategoriaServiceImpl implements ICategoriaService {
	
	@Autowired
	private CategoriaDAO categoriaDAO;

	@Override
	public Categoria createCategoria(Categoria categoria) {
		return categoriaDAO.save(categoria);
	}

	@Override
	public Categoria updateCategora(Categoria categoria) {
		return categoriaDAO.save(categoria);
	}

	@Override
	public Categoria findCategoriaById(Integer id) {
		return categoriaDAO.findById(id).get();
	}

	@Override
	public List<Categoria> findAllByNomeCategoria(String nome) {
		return categoriaDAO.findAllByNomeCategoria(nome);
	}

	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>) categoriaDAO.findAll();
	}

	@Override
	public List<Categoria> findAllByOrderByNomeCategoriaAsc() {
		return (List<Categoria>) categoriaDAO.findAllByOrderByNomeCategoriaAsc();
	}
	
}
