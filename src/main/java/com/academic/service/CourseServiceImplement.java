package com.academic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academic.dto.CourseDTO;
import com.academic.entity.Course;
import com.academic.repository.CourseRepositoryI;
import com.academic.repository.IntituteReposiortyI;

@Service
public class CourseServiceImplement implements CourseServiceI {

	@Autowired
	private CourseRepositoryI courseRepositoryI;
	
	@Autowired
	private IntituteReposiortyI intituteReposiortyI;
	
	
	@Override
	public CourseDTO createCourse(long instituteId, CourseDTO courseDTO) {
		
		
		return null;
	}
	
	
	private CourseDTO mapearDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();
		
		courseDTO.setId(course.getId());
		courseDTO.setName(course.getCo_name());
		courseDTO.setParallel(course.getCo_parallel());
		
		return courseDTO;
	}

}
