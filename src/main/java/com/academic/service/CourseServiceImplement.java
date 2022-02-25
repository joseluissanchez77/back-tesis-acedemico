package com.academic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

	// ModelMapper » 3.0.0
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CourseRepositoryI courseRepositoryI;

	@Autowired
	private IntituteReposiortyI intituteReposiortyI;

	@Autowired
	private StatusRepositoryI statusRepositoryI;

	@Override
	public CourseDTO createCourse(long instituteId, long statusId, CourseDTO courseDTO) {

		Course course = mapearEntidad(courseDTO);
		Institution institution = intituteReposiortyI.findById(instituteId)
				.orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", instituteId));

		Status status = statusRepositoryI.findById(statusId)
				.orElseThrow(() -> new ResourceNotFoundException("Status", "id", statusId));

		course.setStatus(status);
		course.setInstitution(institution);

		Course newCourse = courseRepositoryI.save(course);

		return mapearDTO(newCourse);
	}

	@Override
	public List<CourseDTO> getCourseIdByInstitute(long instituteId) {
		List<Course> courses = courseRepositoryI.findByInstitutionId(instituteId);

		return courses.stream().map(cor -> mapearDTO(cor)).collect(Collectors.toList());
	}

	@Override
	public CourseDTO getCourseById(Long instituteId, Long courseId) {

		Institution institution = intituteReposiortyI.findById(instituteId)
				.orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", instituteId));

		Course course = courseRepositoryI.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Curso", "id", courseId));

		if (!course.getInstitution().getId().equals(institution.getId())) {
			throw new AcademicException(HttpStatus.BAD_REQUEST, "Curso no pertenece a la intitucion");
		}

		return mapearDTO(course);
	}

	@Override
	public CourseDTO updateCourse(Long instituteId, Long courseId, CourseDTO courseDTO) {

		Institution institution = intituteReposiortyI.findById(instituteId)
				.orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", instituteId));

		Course course = courseRepositoryI.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Curso", "id", courseId));

		if (!course.getInstitution().getId().equals(institution.getId())) {
			throw new AcademicException(HttpStatus.BAD_REQUEST, "Curso no pertenece a la intitucion");
		}

		course.setCo_name(courseDTO.getName());
		course.setCo_parallel(courseDTO.getParallel());

		Course courseUpdate = courseRepositoryI.save(course);

		return mapearDTO(courseUpdate);
	}

	@Override
	public void deleteCourse(Long instituteId, Long courseId) {

		Institution institution = intituteReposiortyI.findById(instituteId)
				.orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", instituteId));

		Course course = courseRepositoryI.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Curso", "id", courseId));

		if (!course.getInstitution().getId().equals(institution.getId())) {
			throw new AcademicException(HttpStatus.BAD_REQUEST, "Curso no pertenece a la intitucion");
		}

		courseRepositoryI.delete(course);
	}

	private CourseDTO mapearDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();

		courseDTO.setId(course.getId());
		courseDTO.setName(course.getCo_name());
		courseDTO.setParallel(course.getCo_parallel());

		/*
		 * ModelMapper » 3.0.0
		 * solo funciona si el dto y model son iguales en nombres CourseDTO courseDTO =
		 * modelMapper.map(course, CourseDTO.class);
		 */

		return courseDTO;
	}

	private Course mapearEntidad(CourseDTO courseDTO) {
		Course course = new Course();

		course.setId(courseDTO.getId());
		course.setCo_name(courseDTO.getName());
		course.setCo_parallel(courseDTO.getParallel());
		/*
		 * ModelMapper » 3.0.0
		 * solo funciona si el dto y model son iguales en nombres Course course =
		 * modelMapper.map(courseDTO, Course.class);
		 */

		return course;
	}

}
