package com.academic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academic.dto.CourseDTO;
import com.academic.entity.Course;
import com.academic.entity.Institution;
import com.academic.exception.ResourceNotFoundException;
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
		
		Course course = mapearEntidad(courseDTO);
		Institution institution = intituteReposiortyI.findById(instituteId).
				orElseThrow(()->new ResourceNotFoundException("Institucion", "id", instituteId));
		
		course.setInstitution(institution);
		Course newCourse = courseRepositoryI.save(course);
		
		
		return mapearDTO(newCourse);
	}
	
	
	private CourseDTO mapearDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();
		
		courseDTO.setId(course.getId());
		courseDTO.setName(course.getCo_name());
		courseDTO.setParallel(course.getCo_parallel());
		
		return courseDTO;
	}
	
	
	private Course mapearEntidad(CourseDTO courseDTO) {
		Course course = new Course();
		
		course.setId(courseDTO.getId());
		course.setCo_name(courseDTO.getName());
		course.setCo_parallel(courseDTO.getParallel());
		
		return course;
	}


}
