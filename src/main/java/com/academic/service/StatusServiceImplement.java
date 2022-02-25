package com.academic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.academic.dto.StatusDTO;

import com.academic.entity.Status;
import com.academic.exception.ResourceNotFoundException;
import com.academic.repository.StatusRepositoryI;

@Service
public class StatusServiceImplement implements StatusServiceI {

	@Autowired
	private StatusRepositoryI statusRepositoryI;

	@Override
	public StatusDTO createStatus(StatusDTO statusDTO) {
		// covertir DTO a entidad
		Status status = mapearEntity(statusDTO);

		// covertir ENTIDAD a DTO
		Status newStatus = statusRepositoryI.save(status);

		StatusDTO statusResponse = mapearDTO(newStatus);
		return statusResponse;
	}
	
	
	// metodo q convierte DTO a ENTIDAD
	private Status mapearEntity(StatusDTO statusDTO) {

		Status status = new Status();

		status.setId(statusDTO.getId());
		status.setSt_name(statusDTO.getName());
		status.setSt_keyword(statusDTO.getKeyword());
		//status.setInstitution(statusDTO.get());
		
		return status;

	}
	
	// metodo q convierte ENTIDAD a DTO
	private StatusDTO mapearDTO(Status status) {
		StatusDTO statusDTO = new StatusDTO();

		statusDTO.setId(status.getId());
		statusDTO.setName(status.getSt_name());
		statusDTO.setKeyword(status.getSt_keyword());
		
		return statusDTO;

	}


	@Override
	public StatusDTO updateStatus(StatusDTO statusDTO, long id) {
		Status status = statusRepositoryI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Estado", "id", id));

		// covertir DTO a entidad
		status.setSt_keyword(statusDTO.getKeyword());
		status.setSt_name(statusDTO.getName());
	

		Status newStatus = statusRepositoryI.save(status);

		return mapearDTO(newStatus);
	}


	@Override
	public StatusDTO getStatusById(long id) {
		Status status = statusRepositoryI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Estado", "id", id));

		return mapearDTO(status);
	}


	@Override
	public void deleteStatus(long id) {
		Status status = statusRepositoryI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Estado", "id", id));

		statusRepositoryI.delete(status);
		
	}


	@Override
	public List<StatusDTO> getAllStatus() {
		
		
		List<Status> listOfStatus = statusRepositoryI.findAll();
	
		List<StatusDTO>  contenido = listOfStatus.stream().map(stat -> mapearDTO(stat)).collect(Collectors.toList());
		
		
		return contenido;
	}
	

}
