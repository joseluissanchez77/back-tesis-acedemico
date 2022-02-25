package com.academic.service;

import java.util.List;

import com.academic.dto.CourseDTO;


public interface CourseServiceI {
	
	//crear curso
	public CourseDTO createCourse(long instituteId, long statusId,CourseDTO courseDTO);

	//obtener cruso por id
	public List<CourseDTO> getCourseIdByInstitute(long instituteId);
	
	//obtener por id
	public CourseDTO getCourseById(Long instituteId, Long courseId);
	
	//actualizar curso
	public CourseDTO updateCourse(Long instituteId,  Long courseId, CourseDTO courseDTO);
	
	//eliminar cuso
	public void deleteCourse(Long instituteId, Long courseId);
}
