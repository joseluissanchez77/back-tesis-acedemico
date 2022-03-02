package com.academic.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class StatusDTO {

	private long id;

	@NotEmpty
	@Size(min = 2, message = "Nombre del estado deberia tener minimo 2 caracteres")
	private String name;
	@NotEmpty
	@Size(min = 3, message = "Keyword del estado deberia tener minimo 2 caracteres")
	private String keyword;

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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public StatusDTO(long id, String name, String keyword) {
		super();
		this.id = id;
		this.name = name;
		this.keyword = keyword;
	}

	public StatusDTO() {
		super();
	}

}
