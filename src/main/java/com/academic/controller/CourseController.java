package com.academic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.dto.CourseDTO;
import com.academic.service.CourseServiceImplement;

@RestController
@RequestMapping("/api/")
public class CourseController {
	
	@Autowired
	private CourseServiceImplement courseServiceImplement;
	
	@PostMapping("institute/{institutionId}/course")
	public ResponseEntity<CourseDTO> saveCourse(@PathVariable(value="institutionId") long institutionId, @RequestBody CourseDTO courseDTO){
		return new ResponseEntity<>(courseServiceImplement.createCourse(institutionId, courseDTO),HttpStatus.CREATED);
	}
	
	
	

}
