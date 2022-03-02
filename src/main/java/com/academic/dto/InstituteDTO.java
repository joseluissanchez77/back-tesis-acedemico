package com.academic.dto;

import java.util.Set;

import com.academic.entity.Course;
import com.academic.entity.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class InstituteDTO {

	private Long id;

	private String dto_schoolName;

	private String dto_registrationNumber;

	private String dto_province;

	private String dto_city;

	private String dto_address;

	private String dto_zipCode;

	private String dto_telephoneOne;

	private String dto_telephoneTwo;

	private String dto_email;

	private String dto_directorsName;

	private long status_id;

	public InstituteDTO() {
		super();
	}

	public InstituteDTO(Long id, String dto_schoolName, String dto_registrationNumber, String dto_province,
			String dto_city, String dto_address, String dto_zipCode, String dto_telephoneOne, String dto_telephoneTwo,
			String dto_email, String dto_directorsName, Long status_id/* , Status status */) {
		super();
		this.id = id;
		this.dto_schoolName = dto_schoolName;
		this.dto_registrationNumber = dto_registrationNumber;
		this.dto_province = dto_province;
		this.dto_city = dto_city;
		this.dto_address = dto_address;
		this.dto_zipCode = dto_zipCode;
		this.dto_telephoneOne = dto_telephoneOne;
		this.dto_telephoneTwo = dto_telephoneTwo;
		this.dto_email = dto_email;
		this.dto_directorsName = dto_directorsName;
		this.status_id = status_id;
		// this.status = status;
	}

	public Long getId() {
		return id;
	}

	public long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(long status_id) {
		this.status_id = status_id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDto_schoolName() {
		return dto_schoolName;
	}

	public void setDto_schoolName(String dto_schoolName) {
		this.dto_schoolName = dto_schoolName;
	}

	public String getDto_registrationNumber() {
		return dto_registrationNumber;
	}

	public void setDto_registrationNumber(String dto_registrationNumber) {
		this.dto_registrationNumber = dto_registrationNumber;
	}

	public String getDto_province() {
		return dto_province;
	}

	public void setDto_province(String dto_province) {
		this.dto_province = dto_province;
	}

	public String getDto_city() {
		return dto_city;
	}

	public void setDto_city(String dto_city) {
		this.dto_city = dto_city;
	}

	public String getDto_address() {
		return dto_address;
	}

	public void setDto_address(String dto_address) {
		this.dto_address = dto_address;
	}

	public String getDto_zipCode() {
		return dto_zipCode;
	}

	public void setDto_zipCode(String dto_zipCode) {
		this.dto_zipCode = dto_zipCode;
	}

	public String getDto_telephoneOne() {
		return dto_telephoneOne;
	}

	public void setDto_telephoneOne(String dto_telephoneOne) {
		this.dto_telephoneOne = dto_telephoneOne;
	}

	public String getDto_telephoneTwo() {
		return dto_telephoneTwo;
	}

	public void setDto_telephoneTwo(String dto_telephoneTwo) {
		this.dto_telephoneTwo = dto_telephoneTwo;
	}

	public String getDto_email() {
		return dto_email;
	}

	public void setDto_email(String dto_email) {
		this.dto_email = dto_email;
	}

	public String getDto_directorsName() {
		return dto_directorsName;
	}

	public void setDto_directorsName(String dto_directorsName) {
		this.dto_directorsName = dto_directorsName;
	}

}
