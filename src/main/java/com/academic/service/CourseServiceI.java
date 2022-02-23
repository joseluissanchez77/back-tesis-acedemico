package com.academic.service;

import com.academic.dto.CourseDTO;

public interface CourseServiceI {
	
	public CourseDTO createCourse(long instituteId, CourseDTO courseDTO);

}
