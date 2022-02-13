package com.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academic.entity.Institution;

public interface IntituteReposiortyI extends JpaRepository<Institution, Long> {

}
