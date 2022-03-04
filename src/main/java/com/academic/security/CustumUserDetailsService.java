package com.academic.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.academic.entity.Rol;
import com.academic.entity.Usuario;
import com.academic.repository.UserRepositoryI;

@Service
public class CustumUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepositoryI userRepositoryI;

	// cargar un usuario por su username o emaol
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		Usuario usuario = userRepositoryI.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException(
						"Usuario no encrontrado con ese usuario o email : " + usernameOrEmail));
		return new User(usuario.getEmail(), usuario.getPassword(), mapearRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> roles) {
		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}

}
