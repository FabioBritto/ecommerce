package br.com.brittodev.ecommerce.service.cliente;

import java.util.List;

import br.com.brittodev.ecommerce.model.Cliente;

public interface IClienteService {

	public Cliente createCliente(Cliente cliente);
	public Cliente updateCliente(Cliente cliente);
	public Cliente findClienteById(Integer id);
	public Cliente findClienteByTelefone(String telefone);
	public List<Cliente> findAll();
}
