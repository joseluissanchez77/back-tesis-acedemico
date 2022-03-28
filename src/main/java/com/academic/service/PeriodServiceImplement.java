package com.academic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.academic.dto.PeriodDTO;
import com.academic.dto.PeriodResponse;
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
		periodDTO.setStatus_id(period.getStatus().getId());//--
		periodDTO.setStatus(period.getStatus());

		return periodDTO;

	}

	@Override
	public PeriodResponse getAllPeriod(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<Period> periodPage = periodRepositoryI.findAll(pageable);

		
		List<Period> listOfPeriod = periodPage.getContent();
		List<PeriodDTO> contenido = listOfPeriod.stream().map(periodo -> mapearDTO(periodo))
				.collect(Collectors.toList());

		PeriodResponse periodResponse = new PeriodResponse();
		periodResponse.setContent(contenido);
		periodResponse.setPageNo(periodPage.getNumber());
		periodResponse.setPageSize(periodPage.getSize());
		periodResponse.setTotalElement(periodPage.getTotalElements());
		periodResponse.setTotalPage(periodPage.getTotalPages());
		periodResponse.setLast(periodPage.isLast());

		return periodResponse;
	}

	@Override
	public PeriodDTO getAllPeriodById(long id) {
		Period period = periodRepositoryI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Periodo", "id", id));

		return mapearDTO(period);

	}

	@Override
	public PeriodDTO updatePeriod(PeriodDTO periodDTO, long id) {
		Period period = periodRepositoryI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Periodo", "id", id));

		Status status = statusRepositoryI.findById(periodDTO.getStatus_id())
				.orElseThrow(() -> new ResourceNotFoundException("Estado", "id", periodDTO.getStatus_id()));
		
		// covertir DTO a entidad
		period.setPer_name(periodDTO.getName());
		period.setPer_start_year(periodDTO.getStart_year());
		period.setPer_end_year(periodDTO.getEnd_year());
		period.setStatus(status);

		
		Period newPeriod = periodRepositoryI.save(period);
		PeriodDTO periodResponse = mapearDTO(newPeriod);
		periodResponse.setStatus_id(periodDTO.getStatus_id());
		
		return periodResponse;
	}

	@Override
	public void deletePeriod(long id) {
		Period period = periodRepositoryI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Periodo", "id", id));

		periodRepositoryI.delete(period);
		
	}

	@Override
	public PeriodDTO updateStatusPeriod(PeriodDTO periodDTO, long id) {
		
		Period period = periodRepositoryI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Periodo", "id", id));
		
		Status status = statusRepositoryI.findById(periodDTO.getStatus_id())
				.orElseThrow(() -> new ResourceNotFoundException("Estado", "id", periodDTO.getStatus_id()));
		
		
		period.setStatus(status);

		
		Period newPeriod = periodRepositoryI.save(period);
		PeriodDTO periodResponse = mapearDTO(newPeriod);
		
		
		return periodResponse;
	}

}
