package com.academic.dto;

import java.util.List;

public class InstituteResponse {

	private List<InstituteDTO> content;
	private int pageNo;
	private int pageSize;
	private long totalElement;
	private int totalPage;
	private boolean last;

	public InstituteResponse() {
		super();
	}

	public InstituteResponse(List<InstituteDTO> content, int pageNo, int pageSize, long totalElement, int totalPage,
			boolean last) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElement = totalElement;
		this.totalPage = totalPage;
		this.last = last;
	}

	public List<InstituteDTO> getContent() {
		return content;
	}

	public void setContent(List<InstituteDTO> content) {
		this.content = content;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalElement() {
		return totalElement;
	}

	public void setTotalElement(long totalElement) {
		this.totalElement = totalElement;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

}
