package com.academic.dto.responseGeneral;

import java.util.List;

import com.academic.dto.PeriodCourseDTO;

public class ResponsePeriodCourse {

	private int pageNo;
	private int pageSize;
	private long totalElement;
	private int totalPage;
	private boolean last;

	private List<PeriodCourseDTO> content;

	public ResponsePeriodCourse() {
		super();
	}

	public ResponsePeriodCourse(int pageNo, int pageSize, long totalElement, int totalPage, boolean last,
			List<PeriodCourseDTO> content) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElement = totalElement;
		this.totalPage = totalPage;
		this.last = last;
		this.content = content;
	}

	public List<PeriodCourseDTO> getContent() {
		return content;
	}

	public void setContent(List<PeriodCourseDTO> content) {
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
