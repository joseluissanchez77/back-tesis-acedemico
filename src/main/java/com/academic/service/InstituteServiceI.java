package com.academic.service;

import java.util.List;
import com.academic.dto.InstituteDTO;


public interface InstituteServiceI {
	public InstituteDTO createIsntitute(InstituteDTO instituteDTO);
	
	public List<InstituteDTO> getAllIntitute();
	
	public InstituteDTO getAllIntituteById(long id);
	
	public InstituteDTO updateIntitute(InstituteDTO instituteDTO, long id);
	
	public void deleteInstitute( long id);
}
