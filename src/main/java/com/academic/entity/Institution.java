package com.academic.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "institution", uniqueConstraints = { @UniqueConstraint(columnNames = { "it_schoolName" }) })
public class Institution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "it_schoolName", nullable = false)
	private String it_schoolName;

	@Column(name = "it_registrationNumber", nullable = false)
	private String it_registrationNumber;

	@Column(name = "it_province", nullable = false)
	private String it_province;

	@Column(name = "it_city", nullable = false)
	private String it_city;

	@Column(name = "it_address", nullable = false)
	private String it_address;

	@Column(name = "it_zipCode", nullable = false)
	private String it_zipCode;

	@Column(name = "it_telephoneOne", nullable = false)
	private String it_telephoneOne;

	@Column(name = "it_telephoneTwo", nullable = false)
	private String it_telephoneTwo;

	@Column(name = "it_email", nullable = false)
	private String it_email;

	@Column(name = "it_directorsName", nullable = false)
	private String it_directorsName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;
	
	//orphanRemoval borra las depedencias
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Course> courses = new HashSet<>();

	public Institution() {
		super();
	}


	public Institution(Long id, String it_schoolName, String it_registrationNumber, String it_province, String it_city,
			String it_address, String it_zipCode, String it_telephoneOne, String it_telephoneTwo, String it_email,
			String it_directorsName, Status status) {
		super();
		this.id = id;
		this.it_schoolName = it_schoolName;
		this.it_registrationNumber = it_registrationNumber;
		this.it_province = it_province;
		this.it_city = it_city;
		this.it_address = it_address;
		this.it_zipCode = it_zipCode;
		this.it_telephoneOne = it_telephoneOne;
		this.it_telephoneTwo = it_telephoneTwo;
		this.it_email = it_email;
		this.it_directorsName = it_directorsName;
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIt_schoolName() {
		return it_schoolName;
	}

	public void setIt_schoolName(String it_schoolName) {
		this.it_schoolName = it_schoolName;
	}

	public String getIt_registrationNumber() {
		return it_registrationNumber;
	}

	public void setIt_registrationNumber(String it_registrationNumber) {
		this.it_registrationNumber = it_registrationNumber;
	}

	public String getIt_province() {
		return it_province;
	}

	public void setIt_province(String it_province) {
		this.it_province = it_province;
	}

	public String getIt_city() {
		return it_city;
	}

	public void setIt_city(String it_city) {
		this.it_city = it_city;
	}

	public String getIt_address() {
		return it_address;
	}

	public void setIt_address(String it_address) {
		this.it_address = it_address;
	}

	public String getIt_zipCode() {
		return it_zipCode;
	}

	public void setIt_zipCode(String it_zipCode) {
		this.it_zipCode = it_zipCode;
	}

	public String getIt_telephoneOne() {
		return it_telephoneOne;
	}

	public void setIt_telephoneOne(String it_telephoneOne) {
		this.it_telephoneOne = it_telephoneOne;
	}

	public String getIt_telephoneTwo() {
		return it_telephoneTwo;
	}

	public void setIt_telephoneTwo(String it_telephoneTwo) {
		this.it_telephoneTwo = it_telephoneTwo;
	}

	public String getIt_email() {
		return it_email;
	}

	public void setIt_email(String it_email) {
		this.it_email = it_email;
	}

	public String getIt_directorsName() {
		return it_directorsName;
	}

	public void setIt_directorsName(String it_directorsName) {
		this.it_directorsName = it_directorsName;
	}
}
