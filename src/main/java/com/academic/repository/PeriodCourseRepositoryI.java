package com.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.academic.entity.PeriodCourse;

public interface PeriodCourseRepositoryI  extends JpaRepository<PeriodCourse, Long>{

}
