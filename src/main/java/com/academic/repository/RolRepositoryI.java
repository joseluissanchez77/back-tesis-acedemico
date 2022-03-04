package com.academic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academic.entity.Rol;
import com.academic.entity.Usuario;

public interface RolRepositoryI extends JpaRepository<Usuario, Long>{

	public Optional<Rol> findByName(String nombre);
}
