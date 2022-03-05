package com.academic.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private CustumUserDetailsService custumUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// obtener token de la solicitud http
		String token = obtenerJWTdeLaSolicitud(request);

		// validar el token
		if (StringUtils.hasText(token) && jwtTokenProvider.validarToken(token)) {
			// obtener username del token
			String username = jwtTokenProvider.obtenerUserNameDelJWT(token);

			// cargamos el usuario asociado al token
			UserDetails userDetails = custumUserDetailsService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());

			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			// establecer la seguridad
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);

		}
		// validar filtro
		filterChain.doFilter(request, response);

	}

	// Bearer token de acceso
	private String obtenerJWTdeLaSolicitud(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			// 7 porque se recorta solo el token "Bearer "
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;

	}

}
