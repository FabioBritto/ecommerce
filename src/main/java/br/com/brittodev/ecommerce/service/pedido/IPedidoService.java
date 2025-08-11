package br.com.brittodev.ecommerce.service.pedido;

import java.util.List;

import br.com.brittodev.ecommerce.model.Pedido;

public interface IPedidoService {

	public Pedido create(Pedido pedido);
	public Pedido update(Pedido pedido);
	public List<Pedido> findAll();
	public List<Pedido> findByStatus(Integer status);
	public Pedido findByNumero(Integer numero);
}
