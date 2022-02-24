package com.academic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academic.entity.Course;

public interface CourseRepositoryI extends JpaRepository<Course, Long>{

	public List<Course>findByInstitutionId(Long institutionId);
	
	
}
