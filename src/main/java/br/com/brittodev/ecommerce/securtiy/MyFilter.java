package br.com.brittodev.ecommerce.securtiy;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		/*
		 * Independente do resultado da requisição (inclusive se
		 * ela será permitida ou não) eu passo por este filtro
		 */
		filterChain.doFilter(request, response);
		
	}

}
