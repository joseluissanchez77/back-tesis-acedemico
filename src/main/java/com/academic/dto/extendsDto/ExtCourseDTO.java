package com.academic.dto.extendsDto;

import com.academic.dto.CourseDTO;
import com.academic.entity.Status;

public class ExtCourseDTO extends CourseDTO {

	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
