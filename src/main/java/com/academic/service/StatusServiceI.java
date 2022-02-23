package com.academic.service;

import java.util.List;

import com.academic.dto.StatusDTO;

public interface StatusServiceI {


	//obtener todos
	public List<StatusDTO> getAllStatus();
	
	//crear 
	public StatusDTO createStatus(StatusDTO statusDTO);
	
	//obtener por Id
	public StatusDTO getStatusById(long id);
	
	//actualizar
	public StatusDTO updateStatus(StatusDTO statusDTO, long id);
	
	//borrar
	public void deleteStatus( long id);
	
}
