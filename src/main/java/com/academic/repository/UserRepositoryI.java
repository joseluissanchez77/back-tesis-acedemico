package com.academic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academic.entity.Usuario;

public interface UserRepositoryI extends JpaRepository<Usuario, Long>{

	
	public Optional<Usuario> findByEmail(String email);
	
	public Optional<Usuario> findByUsernameOrEmail(String usurname, String email);
	
	public Optional<Usuario> findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	public Boolean existsByEmail(String email);
}
