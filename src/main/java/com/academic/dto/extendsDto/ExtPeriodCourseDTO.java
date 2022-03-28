package com.academic.dto.extendsDto;

import com.academic.dto.PeriodCourseDTO;
import com.academic.entity.Course;
import com.academic.entity.Period;
import com.academic.entity.Status;

public class ExtPeriodCourseDTO extends PeriodCourseDTO {
	private Period period;
	private Course course;
	private Status status;

	public ExtPeriodCourseDTO() {
		super();
	}

	public ExtPeriodCourseDTO(Period period, Course course, Status status) {
		super();
		this.period = period;
		this.course = course;
		this.status = status;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
