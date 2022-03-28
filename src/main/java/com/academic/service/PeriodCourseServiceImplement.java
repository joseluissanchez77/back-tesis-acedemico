package com.academic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.academic.dto.PeriodCourseDTO;

import com.academic.dto.extendsDto.ExtPeriodCourseDTO;
import com.academic.dto.responseGeneral.ResponsePeriodCourse;
import com.academic.entity.Course;
import com.academic.entity.Period;
import com.academic.entity.PeriodCourse;
import com.academic.entity.Status;
import com.academic.exception.ResourceNotFoundException;
import com.academic.repository.CourseRepositoryI;
import com.academic.repository.PeriodCourseRepositoryI;
import com.academic.repository.PeriodRepositoryI;
import com.academic.repository.StatusRepositoryI;

@Service
public class PeriodCourseServiceImplement implements PeriodCourseServiceI {

	@Autowired
	private PeriodCourseRepositoryI periodCourseRepositoryI;

	@Autowired
	private PeriodRepositoryI periodRepositoryI;

	@Autowired
	private CourseRepositoryI courseRepositoryI;

	@Autowired
	private StatusRepositoryI statusRepositoryI;

	@Override
	public PeriodCourseDTO createPeriodCourse(PeriodCourseDTO periodCourseDTO) {
		// covertir DTO a entidad
		PeriodCourse periodCourse = new PeriodCourse();
		periodCourse.setId(periodCourseDTO.getId());

		Period period = periodRepositoryI.findById(periodCourseDTO.getPeriod_id())
				.orElseThrow(() -> new ResourceNotFoundException("Periodo", "id", periodCourseDTO.getPeriod_id()));

		Course course = courseRepositoryI.findById(periodCourseDTO.getCourse_id())
				.orElseThrow(() -> new ResourceNotFoundException("Curso", "id", periodCourseDTO.getCourse_id()));

		Status status = statusRepositoryI.findById(periodCourseDTO.getStatus_id())
				.orElseThrow(() -> new ResourceNotFoundException("Estado", "id", periodCourseDTO.getStatus_id()));

		periodCourse.setPeriod(period);
		periodCourse.setCourse(course);
		periodCourse.setStatus(status);
		// covertir ENTIDAD a DTO
		PeriodCourse newPeriodCourse = periodCourseRepositoryI.save(periodCourse);

		PeriodCourseDTO periodoCourseResponse = mapearDTO(newPeriodCourse);
//		
		return periodoCourseResponse;

	}

	// metodo q convierte ENTIDAD a DTO
	private PeriodCourseDTO mapearDTO(PeriodCourse periodCourse) {
		ExtPeriodCourseDTO extPeriodCourseDTO = new ExtPeriodCourseDTO();

		extPeriodCourseDTO.setId(periodCourse.getId());

		extPeriodCourseDTO.setPeriod_id(periodCourse.getPeriod().getId());// --
		extPeriodCourseDTO.setPeriod(periodCourse.getPeriod());

		extPeriodCourseDTO.setCourse_id(periodCourse.getCourse().getId());// --
		extPeriodCourseDTO.setCourse(periodCourse.getCourse());

		extPeriodCourseDTO.setStatus_id(periodCourse.getStatus().getId());// --
		extPeriodCourseDTO.setStatus(periodCourse.getStatus());

		return extPeriodCourseDTO;

	}

	@Override
	public ResponsePeriodCourse getAllPeriodCourse(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<PeriodCourse> periodCoursePage = periodCourseRepositoryI.findAll(pageable);

		List<PeriodCourse> listOfPeriodCourse = periodCoursePage.getContent();
		List<PeriodCourseDTO> contenido = listOfPeriodCourse.stream().map(periodoCourse -> mapearDTO(periodoCourse))
				.collect(Collectors.toList());

		ResponsePeriodCourse periodCourseResponse = new ResponsePeriodCourse();
		periodCourseResponse.setContent(contenido);
		periodCourseResponse.setPageNo(periodCoursePage.getNumber());
		periodCourseResponse.setPageSize(periodCoursePage.getSize());
		periodCourseResponse.setTotalElement(periodCoursePage.getTotalElements());
		periodCourseResponse.setTotalPage(periodCoursePage.getTotalPages());
		periodCourseResponse.setLast(periodCoursePage.isLast());

		return periodCourseResponse;
	}

}
