package com.academic.exception;

import org.springframework.http.HttpStatus;

public class AcademicException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private HttpStatus stateCode;
	private String messaje;
	public AcademicException(HttpStatus stateCode, String messaje) {
		super();
		this.stateCode = stateCode;
		this.messaje = messaje;
	}
	
	public AcademicException(HttpStatus stateCode, String messaje, String messaje1) {
		super();
		this.stateCode = stateCode;
		this.messaje = messaje;
		this.messaje = messaje1;
	}
	public AcademicException() {
		super();
	}

	public HttpStatus getStateCode() {
		return stateCode;
	}

	public void setStateCode(HttpStatus stateCode) {
		this.stateCode = stateCode;
	}

	public String getMessaje() {
		return messaje;
	}

	public void setMessaje(String messaje) {
		this.messaje = messaje;
	}
	
	
}
