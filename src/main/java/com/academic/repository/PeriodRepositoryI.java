package com.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.academic.entity.Period;

public interface PeriodRepositoryI extends JpaRepository<Period, Long> {

}
