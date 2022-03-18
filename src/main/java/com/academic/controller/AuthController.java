package com.academic.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.dto.LoginDTO;
import com.academic.dto.RegisterUserDTO;
import com.academic.entity.Rol;
import com.academic.entity.Usuario;
import com.academic.repository.RolRepositoryI;
import com.academic.repository.UserRepositoryI;
import com.academic.security.JWTAuthResonseDTO;
import com.academic.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepositoryI userRepositoryI;

	@Autowired
	private RolRepositoryI rolRepositoryI;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@PostMapping("/login")
	public ResponseEntity<JWTAuthResonseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		// obtenemos el token del jwt provider
		String token = jwtTokenProvider.generaToken(authentication);
		System.out.println(token);

		return ResponseEntity.ok(new JWTAuthResonseDTO(token));

		// return new ResponseEntity<>("Ha iniciado session con exito", HttpStatus.OK);

	}

	@PostMapping("/register/user")
	public ResponseEntity<?> registerUser(@RequestBody RegisterUserDTO registerUserDTO) {

		if (userRepositoryI.existsByUsername(registerUserDTO.getUsername())) {
			return new ResponseEntity<>("Nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		if (userRepositoryI.existsByUsername(registerUserDTO.getEmail())) {
			return new ResponseEntity<>("Email de usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		Usuario usuario = new Usuario();
		usuario.setName(registerUserDTO.getName());
		usuario.setUsername(registerUserDTO.getUsername());
		usuario.setEmail(registerUserDTO.getEmail());
		usuario.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));

		Rol roles = rolRepositoryI.findByNombre("ROLE_ADMIN").get();
		usuario.setRoles(Collections.singleton(roles));// singleton uno solo rol para el usuario

		userRepositoryI.save(usuario);

		return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);

	}

}
