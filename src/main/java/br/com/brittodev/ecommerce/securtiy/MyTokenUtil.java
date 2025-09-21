package br.com.brittodev.ecommerce.securtiy;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.brittodev.ecommerce.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class MyTokenUtil {

	private static final long SEGUNDO = 1000;
	private static final long MINUTO = 60 * SEGUNDO;
	private static final long HORA = 60 * MINUTO;
	
	public static final String EMISSOR = "FABIO BRITTO";
	public static final String TOKEN_KEY = "01234567890123456789012345678901";
	public static final String TOKEN_HEADER = "Bearer ";
	
	
	public static MyToken generateToken(Usuario usuario) {
		Key secretKey = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes());
		String jwt = Jwts.builder().setSubject(usuario.getLogin())
                                   .setIssuer(EMISSOR)
								   .setExpiration(new Date(System.currentTimeMillis() + HORA))
								   .signWith(secretKey, SignatureAlgorithm.HS256).compact();
		MyToken token = new MyToken();
		token.setToken(TOKEN_HEADER + jwt);
		return token;
	}
	
	public static Authentication decodeToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		token = token.replace(TOKEN_HEADER, "");
		
		Key key = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes(StandardCharsets.UTF_8));


	    Jws<Claims> jwsClaims = Jwts.parser()
	            .verifyWith((SecretKey) key)
	            .build()
	            .parseSignedClaims(token);
	    String user = jwsClaims.getPayload().getSubject();
	    String emissor = jwsClaims.getPayload().getIssuer();
	    Date validade = jwsClaims.getPayload().getExpiration();
	    
	    if(user.length() > 0 && emissor.equals(EMISSOR) && validade.after(new Date(System.currentTimeMillis()))) {
            //Aqui é onde eu defino ROLES e PERMISSIONS, limitando e restringindo acessos :)
	    	return new UsernamePasswordAuthenticationToken(user, null, Collections.EMPTY_LIST);
	    }
	    return null;

	}
}
