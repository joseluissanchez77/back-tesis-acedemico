package com.academic.entity;

import java.util.Date;
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

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "period", uniqueConstraints = { @UniqueConstraint(columnNames = { "per_name" }) })
public class Period {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "per_name", nullable = false)
	private String per_name;

	@Column(name = "per_start_year", nullable = false)
	private Date per_start_year;

	@Column(name = "per_end_year", nullable = false)
	private Date per_end_year;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;


	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "academicPeriod_course", joinColumns = @JoinColumn(name = "academic_period_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
//	private Set<Course> courses = new HashSet<>();

	public Period() {
		super();
	}

	public Period(Long id, String per_name, Date per_start_year, Date per_end_year, Status status) {
		super();
		this.id = id;
		this.per_name = per_name;
		this.per_start_year = per_start_year;
		this.per_end_year = per_end_year;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPer_name() {
		return per_name;
	}

	public void setPer_name(String per_name) {
		this.per_name = per_name;
	}

	public Date getPer_start_year() {
		return per_start_year;
	}

	public void setPer_start_year(Date per_start_year) {
		this.per_start_year = per_start_year;
	}

	public Date getPer_end_year() {
		return per_end_year;
	}

	public void setPer_end_year(Date per_end_year) {
		this.per_end_year = per_end_year;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
