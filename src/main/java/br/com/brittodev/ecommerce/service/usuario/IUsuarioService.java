package br.com.brittodev.ecommerce.service.usuario;

import br.com.brittodev.ecommerce.model.Usuario;
import br.com.brittodev.ecommerce.securtiy.MyToken;

public interface IUsuarioService {

	public Usuario create(Usuario usuario);
	public Usuario update(Usuario usuario);
	public MyToken login(String login, String senha);
}
