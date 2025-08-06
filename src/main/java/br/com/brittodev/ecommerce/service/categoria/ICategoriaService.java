package br.com.brittodev.ecommerce.service.categoria;

import java.util.List;

import br.com.brittodev.ecommerce.model.Categoria;

public interface ICategoriaService {

	public Categoria createCategoria(Categoria categoria);
	public Categoria updateCategora(Categoria categoria);
	public Categoria findCategoriaById(Integer id);
	public List<Categoria> findAllByNomeCategoria(String nome);
	public List<Categoria> findAllByOrderByNomeCategoriaAsc();
	public List<Categoria> findAll();
}
