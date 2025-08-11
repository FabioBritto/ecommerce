package br.com.brittodev.ecommerce.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.brittodev.ecommerce.dao.UsuarioDAO;
import br.com.brittodev.ecommerce.model.Usuario;
import br.com.brittodev.ecommerce.securtiy.Token;

@Component
public class UsuarioServiceImpl implements IUsuarioService {

	
	@Autowired
	private UsuarioDAO dao;
	
	
	@Override
	public Usuario create(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String novaSenha = encoder.encode(usuario.getSenha());
		usuario.setSenha(novaSenha);
		return dao.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String novaSenha = encoder.encode(usuario.getSenha());
		usuario.setSenha(novaSenha);
		return dao.save(usuario);
	}

	@Override
	public Token login(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

}
