package com.academic.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "status")
@Table(name = "status", uniqueConstraints = { @UniqueConstraint(columnNames = { "st_name" }) })
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "st_name", nullable = false)
	private String st_name;
	
	@Column(name = "st_keyword", nullable = false)
	private String st_keyword;

	@JsonBackReference
	@OneToMany(mappedBy = "status",cascade= CascadeType.ALL, orphanRemoval = true)
	private Set<Institution> institution;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getSt_keyword() {
		return st_keyword;
	}

	public void setSt_keyword(String st_keyword) {
		this.st_keyword = st_keyword;
	}

	public Set<Institution> getInstitution() {
		return institution;
	}

	public void setInstitution(Set<Institution> institution) {
		this.institution = institution;
	}

	public Status(long id, String st_name, String st_keyword, Set<Institution> institution) {
		super();
		this.id = id;
		this.st_name = st_name;
		this.st_keyword = st_keyword;
		this.institution = institution;
	}

	public Status() {
		super();
	}

}
