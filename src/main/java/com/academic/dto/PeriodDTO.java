package com.academic.dto;

import java.util.Date;

public class PeriodDTO {

	private Long id;
	private String name;
	private Date start_year;
	private Date end_year;
	private long status_id;

	public PeriodDTO() {
		super();
	}

	public PeriodDTO(Long id, String name, Date start_year, Date end_year, long status_id) {
		super();
		this.id = id;
		this.name = name;
		this.start_year = start_year;
		this.end_year = end_year;
		this.status_id = status_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart_year() {
		return start_year;
	}

	public void setStart_year(Date start_year) {
		this.start_year = start_year;
	}

	public Date getEnd_year() {
		return end_year;
	}

	public void setEnd_year(Date end_year) {
		this.end_year = end_year;
	}

	public long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(long status_id) {
		this.status_id = status_id;
	}

	

}
