package com.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academic.entity.Status;

public interface StatusRepositoryI extends JpaRepository<Status, Long> {

}
