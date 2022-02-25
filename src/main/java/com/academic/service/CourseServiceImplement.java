package com.academic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.academic.dto.CourseDTO;
import com.academic.entity.Course;
import com.academic.entity.Institution;
import com.academic.entity.Status;
import com.academic.exception.AcademicException;
import com.academic.exception.ResourceNotFoundException;
import com.academic.repository.CourseRepositoryI;
import com.academic.repository.IntituteReposiortyI;
import com.academic.repository.StatusRepositoryI;

@Service
public class CourseServiceImplement implements CourseServiceI {

	@Autowired
	private CourseRepositoryI courseRepositoryI;
	
	@Autowired
	private IntituteReposiortyI intituteReposiortyI;
	
	@Autowired
	private StatusRepositoryI statusRepositoryI;
	
	
	@Override
	public CourseDTO createCourse(long instituteId, long statusId, CourseDTO courseDTO) {
		
		Course course = mapearEntidad(courseDTO);
		Institution institution = intituteReposiortyI.findById(instituteId).
				orElseThrow(()->new ResourceNotFoundException("Institucion", "id", instituteId));
		
		Status status = statusRepositoryI.findById(statusId).
				orElseThrow(()->new ResourceNotFoundException("Status", "id", statusId));
		
		
		course.setStatus(status);
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


	@Override
	public List<CourseDTO> getCourseIdByInstitute(long instituteId) {
		List<Course> courses = courseRepositoryI.findByInstitutionId(instituteId);
		
		return courses.stream().map(cor -> mapearDTO(cor)).collect(Collectors.toList());
	}


	@Override
	public CourseDTO getCourseById(long instituteId, long courseId) {
		
		Institution institution = intituteReposiortyI.findById(instituteId).
				orElseThrow(()->new ResourceNotFoundException("Institucion", "id", instituteId));
		
		Course course = courseRepositoryI.findById(courseId)
				.orElseThrow(()->new ResourceNotFoundException("Curso", "id", courseId));
		
		if(!course.getInstitution().getId().equals(institution.getId())) {
			throw new AcademicException(HttpStatus.BAD_REQUEST,"Curso no pertenece a la intitucion");
		}
		
		return mapearDTO(course);
	}


}
