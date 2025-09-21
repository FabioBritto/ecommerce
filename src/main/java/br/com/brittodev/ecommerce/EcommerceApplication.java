package br.com.brittodev.ecommerce;

import br.com.brittodev.ecommerce.dao.UsuarioDAO;
import br.com.brittodev.ecommerce.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
	}

}
