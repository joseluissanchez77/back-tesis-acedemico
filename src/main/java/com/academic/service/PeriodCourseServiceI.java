package com.academic.service;

import com.academic.dto.PeriodCourseDTO;

import com.academic.dto.responseGeneral.ResponsePeriodCourse;

public interface PeriodCourseServiceI {

	public PeriodCourseDTO createPeriodCourse(PeriodCourseDTO periodCourseDTO);

	public ResponsePeriodCourse getAllPeriodCourse(int pageNo, int pageSize, String sortBy, String sortDir);

}
