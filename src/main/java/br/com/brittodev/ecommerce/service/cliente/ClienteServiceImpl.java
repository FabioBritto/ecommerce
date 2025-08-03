package br.com.brittodev.ecommerce.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brittodev.ecommerce.dao.ClienteDAO;
import br.com.brittodev.ecommerce.model.Cliente;

@Component
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public Cliente createCliente(Cliente cliente) {
		if(cliente != null) return clienteDAO.save(cliente);
		return null;
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		if(cliente != null) return clienteDAO.save(cliente);
		return null;
	}

	@Override
	public Cliente findClienteById(Integer id) {
		if(id != null) return clienteDAO.findById(id).get();
		return null;
	}

	@Override
	public Cliente findClienteByTelefone(String telefone) {
		if(telefone != null) return clienteDAO.findByTelefone(telefone);
		return null;
	}

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDAO.findAll();
	}

}
