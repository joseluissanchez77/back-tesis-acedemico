package com.academic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("institute/{institutionId}/course")
	public List<CourseDTO> listCourseByInstitute(@PathVariable(value = "institutionId") Long institutionId) {
		return courseServiceImplement.getCourseIdByInstitute(institutionId);
	}
	
	@GetMapping("institute/{institutionId}/course/{id}")
	public ResponseEntity<CourseDTO> getCourseByInstitute(
			@PathVariable(value = "institutionId") Long institutionId,
			@PathVariable(value = "id") Long courseId) {
		
		CourseDTO courseDTO = courseServiceImplement.getCourseById(institutionId,courseId);
		
		return new ResponseEntity<>(courseDTO,HttpStatus.OK);
	}

	@PostMapping("institute/{institutionId}/status/{statusId}/course")
	public ResponseEntity<CourseDTO> saveCourse(@PathVariable(value = "institutionId") long institutionId,
			@PathVariable(value = "statusId") long statusId, @RequestBody CourseDTO courseDTO) {
		return new ResponseEntity<>(courseServiceImplement.createCourse(institutionId, statusId, courseDTO),
				HttpStatus.CREATED);
	}

	@PutMapping("institute/{institutionId}/course/{id}")
	public ResponseEntity<CourseDTO> updateCourse(
			@PathVariable(value = "institutionId") Long institutionId,
			@PathVariable(value = "id") Long courseId,
			@RequestBody CourseDTO courseDTO) {
		CourseDTO courseDTOUpdate = courseServiceImplement.updateCourse(institutionId, courseId, courseDTO);
		return new ResponseEntity<>(courseDTOUpdate,
				HttpStatus.OK);
	}
	
	@DeleteMapping("institute/{institutionId}/course/{id}")
	public ResponseEntity<String> deleteCourse(
			@PathVariable(value = "institutionId") Long institutionId,
			@PathVariable(value = "id") Long courseId)
	{
		courseServiceImplement.deleteCourse(institutionId, courseId);
		return new ResponseEntity<>("Curso Eliminado",HttpStatus.OK);
	}
}
