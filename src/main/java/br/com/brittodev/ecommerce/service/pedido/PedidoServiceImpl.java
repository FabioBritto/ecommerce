package br.com.brittodev.ecommerce.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brittodev.ecommerce.dao.PedidoDAO;
import br.com.brittodev.ecommerce.model.ItemPedido;
import br.com.brittodev.ecommerce.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private PedidoDAO pedidoDAO;

	@Override
	public Pedido create(Pedido pedido) {
		// Aqui, eu faço a associação do Item ao pedido correspondente
		double total = 0.0;
		for (ItemPedido item : pedido.getItens()) {
			item.setPedido(pedido);
			total += item.getValorTotal();
		}
		pedido.setValorBruto(total);
		return pedidoDAO.save(pedido);
	}

	@Override
	public Pedido update(Pedido pedido) {
		return pedidoDAO.save(pedido);
	}

	@Override
	public List<Pedido> findAll() {
		return (List<Pedido>) pedidoDAO.findAll();
	}

	@Override
	public List<Pedido> findByStatus(Integer status) {
		return (List<Pedido>) pedidoDAO.findAllByStatus(status);
	}

	@Override
	public Pedido findByNumero(Integer numero) {
		return pedidoDAO.findById(numero).orElse(null);
	}

}
