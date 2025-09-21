package br.com.brittodev.ecommerce.securtiy;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(request.getHeader("Authorization") != null) {
			Authentication auth = MyTokenUtil.decodeToken(request);
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		/*
		 * Independente do resultado da requisição (inclusive se
		 * ela será permitida ou não) eu passo por este filtro
		 */
		filterChain.doFilter(request, response);
		
	}

}
