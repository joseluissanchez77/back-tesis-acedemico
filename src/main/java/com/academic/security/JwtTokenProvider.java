package com.academic.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.academic.exception.AcademicException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	// clase para generar token, validar token

	@Value("${app.jwt.secret}")
	private String jwtSecret;

	@Value("${app.jwt.expiration-milliseconds}")
	private int jwtExpirationInMs;

	public String generaToken(Authentication authentication) {
		String username = authentication.getName();

		Date fechaActual = new Date();
		Date fechaExpiracion = new Date(fechaActual.getTime() + jwtExpirationInMs);

		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

		return token;

	}

	public String obtenerUserNameDelJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public boolean validarToken(String token) {
		try {
			// validar token con su llave secreta
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);

			return true;
		} catch (SignatureException ex) {
			throw new AcademicException(HttpStatus.BAD_REQUEST, "Firma JWT no valida");
		} catch (MalformedJwtException ex) {
			throw new AcademicException(HttpStatus.BAD_REQUEST, "Token JWT no valida");
		} catch (ExpiredJwtException ex) {
			throw new AcademicException(HttpStatus.BAD_REQUEST, "Token JWT caducado");
		} catch (UnsupportedJwtException ex) {
			throw new AcademicException(HttpStatus.BAD_REQUEST, "Token JWT no compatible");
		} catch (IllegalArgumentException ex) {
			throw new AcademicException(HttpStatus.BAD_REQUEST, "La cadena claims JWT esta vacia");
		}

	}

}
