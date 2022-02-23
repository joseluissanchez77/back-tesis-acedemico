package com.academic.dto;

public class StatusDTO {

		
	private long id;

	private String name;
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
