package com.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academic.entity.Course;

public interface CourseRepositoryI extends JpaRepository<Course, Long>{

}
