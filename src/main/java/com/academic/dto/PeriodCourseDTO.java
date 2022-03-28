package com.academic.dto;

public class PeriodCourseDTO {

	private Long id;
	private long course_id;
	private long period_id;
	private long status_id;

	public PeriodCourseDTO() {
		super();
	}

	public PeriodCourseDTO(Long id, long course_id, long period_id, long status_id) {
		super();
		this.id = id;
		this.course_id = course_id;
		this.period_id = period_id;
		this.status_id = status_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public long getPeriod_id() {
		return period_id;
	}

	public void setPeriod_id(long period_id) {
		this.period_id = period_id;
	}

	public long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(long status_id) {
		this.status_id = status_id;
	}

}
