package com.academic.dto.extendsDto;

import java.util.Set;

import com.academic.dto.InstituteDTO;
import com.academic.entity.Course;
import com.academic.entity.Status;

public class ExtInstituteDTO extends InstituteDTO {

	public ExtInstituteDTO() {
		super();
	}

	public ExtInstituteDTO(Set<Course> course, Status status) {
		super();
		this.course = course;
		this.status = status;
	}

	private Set<Course> course;

	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}
}
