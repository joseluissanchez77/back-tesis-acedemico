package com.academic.dto.extendsDto;

import com.academic.dto.PeriodDTO;
import com.academic.entity.Status;

public class ExtPeriodDTO extends PeriodDTO {

	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
