package com.academic.service;

import com.academic.dto.InstituteDTO;
import com.academic.dto.InstituteResponse;

public interface InstituteServiceI {
	public InstituteDTO createIsntitute(InstituteDTO instituteDTO);

	// public List<InstituteDTO> getAllIntitute(int pageNo,int pageSize);
	public InstituteResponse getAllIntitute(int pageNo, int pageSize, String sortBy, String sortDir);

	public InstituteDTO getAllIntituteById(long id);

	public InstituteDTO updateIntitute(InstituteDTO instituteDTO, long id);

	public void deleteInstitute(long id);
}
