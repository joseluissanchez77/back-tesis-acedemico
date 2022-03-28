package com.academic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academic.dto.PeriodCourseDTO;

import com.academic.dto.responseGeneral.ResponsePeriodCourse;
import com.academic.service.PeriodCourseServiceI;
import com.academic.util.AppConstants;

@RestController
@RequestMapping("/api/period-course")
public class PeriodCourseController {

	@Autowired
	private PeriodCourseServiceI periodCourseServiceI;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping()
	public ResponseEntity<PeriodCourseDTO> savePeriodCourse(@RequestBody PeriodCourseDTO periodCourseDTO) {
		return new ResponseEntity<>(periodCourseServiceI.createPeriodCourse(periodCourseDTO), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ResponsePeriodCourse listAllPeriodCourse(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int numberPage,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_DEFAULT, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_ADDRESS_BY_DEFAULT, required = false) String sortDir) {
		return periodCourseServiceI.getAllPeriodCourse(numberPage, pageSize, sortBy, sortDir);
	}

}
