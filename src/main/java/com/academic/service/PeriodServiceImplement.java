package com.academic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academic.dto.PeriodDTO;

import com.academic.dto.extendsDto.ExtPeriodDTO;

import com.academic.entity.Period;
import com.academic.entity.Status;
import com.academic.exception.ResourceNotFoundException;
import com.academic.repository.PeriodRepositoryI;
import com.academic.repository.StatusRepositoryI;

@Service
public class PeriodServiceImplement implements PeriodServiceI {

	@Autowired
	private PeriodRepositoryI periodRepositoryI;

	@Autowired
	private StatusRepositoryI statusRepositoryI;

	@Override
	public PeriodDTO createPeriod(PeriodDTO periodDTO) {
		// covertir DTO a entidad
		Period periodo = mapearEntity(periodDTO);

		Status status = statusRepositoryI.findById(periodDTO.getStatus_id())
				.orElseThrow(() -> new ResourceNotFoundException("Estadi", "id", periodDTO.getStatus_id()));

		periodo.setStatus(status);
		// covertir ENTIDAD a DTO
		Period newPeriod = periodRepositoryI.save(periodo);

		PeriodDTO periodoResponse = mapearDTO(newPeriod);
		periodoResponse.setStatus_id(periodDTO.getStatus_id());
		return periodoResponse;
	}

	// metodo q convierte DTO a ENTIDAD
	private Period mapearEntity(PeriodDTO periodDTO) {

		Period period = new Period();

		period.setId(periodDTO.getId());
		period.setPer_name(periodDTO.getName());
		period.setPer_start_year(periodDTO.getStart_year());
		period.setPer_end_year(periodDTO.getEnd_year());

		return period;

	}

	// metodo q convierte ENTIDAD a DTO
	private PeriodDTO mapearDTO(Period period) {
		ExtPeriodDTO periodDTO = new ExtPeriodDTO();

		periodDTO.setId(period.getId());
		periodDTO.setName(period.getPer_name());
		periodDTO.setStart_year(period.getPer_start_year());
		periodDTO.setEnd_year(period.getPer_end_year());

		periodDTO.setStatus(period.getStatus());

		return periodDTO;

	}

}
