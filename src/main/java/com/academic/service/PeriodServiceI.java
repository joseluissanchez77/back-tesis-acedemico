package com.academic.service;


import com.academic.dto.PeriodDTO;
import com.academic.dto.PeriodResponse;

public interface PeriodServiceI {
	public PeriodDTO createPeriod(PeriodDTO periodDTO);
	
	public PeriodResponse getAllPeriod(int pageNo, int pageSize, String sortBy, String sortDir);
	
	public PeriodDTO getAllPeriodById(long id);
	
	public PeriodDTO updatePeriod(PeriodDTO periodDTO, long id);

	public PeriodDTO updateStatusPeriod(PeriodDTO periodDTO, long id);
	public void deletePeriod(long id);

}
