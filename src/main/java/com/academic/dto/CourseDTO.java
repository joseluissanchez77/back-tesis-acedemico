package com.academic.dto;

import com.academic.entity.Status;

public class CourseDTO {

	private long id;
	private String name;
	private String parallel;

//	private long institution_id;
	/*
	 * private Status status; private Institution institution;
	 */
	public CourseDTO() {
		super();
	}

	public CourseDTO(long id, String name, String parallel, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.parallel = parallel;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParallel() {
		return parallel;
	}

	public void setParallel(String parallel) {
		this.parallel = parallel;
	}

}
