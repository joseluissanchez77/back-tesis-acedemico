package com.academic.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "academicPeriod")
public class AcademicPeriod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "acp_start_year", nullable = false)
	private String acp_start_year;
	@Column(name = "acp_end_year", nullable = false)
	private String acp_end_year;
	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "academicPeriod_course", joinColumns = @JoinColumn(name = "academic_period_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	private Set<Course> courses = new HashSet<>();

	

	public AcademicPeriod() {
		super();
	}

	

	public AcademicPeriod(Long id, String acp_start_year, String acp_end_year, Status status, Set<Course> courses) {
		super();
		this.id = id;
		this.acp_start_year = acp_start_year;
		this.acp_end_year = acp_end_year;
		this.status = status;
		this.courses = courses;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAcp_start_year() {
		return acp_start_year;
	}


	public void setAcp_start_year(String acp_start_year) {
		this.acp_start_year = acp_start_year;
	}


	public String getAcp_end_year() {
		return acp_end_year;
	}


	public void setAcp_end_year(String acp_end_year) {
		this.acp_end_year = acp_end_year;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	

}
