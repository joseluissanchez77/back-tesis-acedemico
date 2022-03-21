package com.academic.dto;

import java.util.Date;

public class ResponseDetailsDTO {

	private Date timestamp;
	private String message;
	private String details;
	private Integer statusCode;
	private Long id;

	public ResponseDetailsDTO() {
		super();
	}

	public ResponseDetailsDTO(Date timestamp, String message, String details, Integer statusCode, Long id) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.statusCode = statusCode;
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
