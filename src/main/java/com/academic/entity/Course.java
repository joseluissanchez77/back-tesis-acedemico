package com.academic.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Course")
@Table(name = "Course", uniqueConstraints = { @UniqueConstraint(columnNames = { "co_name" }) })
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "co_name", nullable = false)
	private String co_name;

	@Column(name = "co_parallel", nullable = false)
	private String co_parallel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="institution_id", nullable = false)
	private Institution institution;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCo_name() {
		return co_name;
	}

	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}

	public String getCo_parallel() {
		return co_parallel;
	}

	public void setCo_parallel(String co_parallel) {
		this.co_parallel = co_parallel;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Course() {
		super();
	}

	public Course(Long id, String co_name, String co_parallel, Status status, Institution institution) {
		super();
		this.id = id;
		this.co_name = co_name;
		this.co_parallel = co_parallel;
		this.status = status;
		this.institution = institution;
	}
	
	

}
