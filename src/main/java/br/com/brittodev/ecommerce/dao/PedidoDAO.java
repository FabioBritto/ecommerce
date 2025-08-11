package br.com.brittodev.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.brittodev.ecommerce.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer>{

	public List<Pedido> findAllByStatus(Integer status);
}
