package com.academic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academic.entity.Rol;


public interface RolRepositoryI extends JpaRepository<Rol, Long>{

	public Optional<Rol> findByNombre(String nombre);
}
