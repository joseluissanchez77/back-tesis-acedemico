package com.academic.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academic.dto.InstituteDTO;
import com.academic.entity.Institution;
import com.academic.exception.ResourceNotFoundException;
import com.academic.repository.IntituteReposiortyI;

@Service
public class InstituteServiceImplement implements InstituteServiceI {
	@Autowired
	private IntituteReposiortyI intituteReposiortyI;

	@Override
	public InstituteDTO createIsntitute(InstituteDTO instituteDTO) {
		// covertir DTO a entidad
		Institution institution = mapearEntity(instituteDTO);

		// covertir ENTIDAD a DTO
		Institution newInstitution = intituteReposiortyI.save(institution);

		InstituteDTO institutionResponse = mapearDTO(newInstitution);
		return institutionResponse;
	}

	@Override
	public List<InstituteDTO> getAllIntitute() {
		List<Institution> institute = intituteReposiortyI.findAll();
		return institute.stream().map(intitu -> mapearDTO(intitu)).collect(Collectors.toList());

	}

	// metodo q convierte ENTIDAD a DTO
	private InstituteDTO mapearDTO(Institution institute) {
		InstituteDTO instituteDTO = new InstituteDTO();

		instituteDTO.setId(institute.getId());
		instituteDTO.setDto_schoolName(institute.getIt_schoolName());
		instituteDTO.setDto_registrationNumber(institute.getIt_registrationNumber());
		instituteDTO.setDto_province(institute.getIt_province());
		instituteDTO.setDto_city(institute.getIt_city());
		instituteDTO.setDto_address(institute.getIt_address());
		instituteDTO.setDto_zipCode(institute.getIt_zipCode());
		instituteDTO.setDto_telephoneOne(institute.getIt_telephoneOne());
		instituteDTO.setDto_telephoneTwo(institute.getIt_telephoneTwo());
		instituteDTO.setDto_email(institute.getIt_email());
		instituteDTO.setDto_directorsName(institute.getIt_directorsName());

		return instituteDTO;

	}

	// metodo q convierte DTO a ENTIDAD
	private Institution mapearEntity(InstituteDTO instituteDTO) {

		Institution institute = new Institution();

		institute.setId(instituteDTO.getId());
		institute.setIt_schoolName(instituteDTO.getDto_schoolName());
		institute.setIt_registrationNumber(instituteDTO.getDto_registrationNumber());
		institute.setIt_province(instituteDTO.getDto_province());
		institute.setIt_city(instituteDTO.getDto_city());
		institute.setIt_address(instituteDTO.getDto_address());
		institute.setIt_zipCode(instituteDTO.getDto_zipCode());
		institute.setIt_telephoneOne(instituteDTO.getDto_telephoneOne());
		institute.setIt_telephoneTwo(instituteDTO.getDto_telephoneTwo());
		institute.setIt_email(instituteDTO.getDto_email());
		institute.setIt_directorsName(instituteDTO.getDto_directorsName());

		return institute;

	}

	@Override
	public InstituteDTO getAllIntituteById(long id) {

		Institution institution = intituteReposiortyI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", id));

		return mapearDTO(institution);

	}

	@Override
	public InstituteDTO updateIntitute(InstituteDTO instituteDTO, long id) {

		Institution institution = intituteReposiortyI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", id));

		// covertir DTO a entidad
		institution.setIt_schoolName(instituteDTO.getDto_schoolName());
		institution.setIt_registrationNumber(instituteDTO.getDto_registrationNumber());
		institution.setIt_province(instituteDTO.getDto_province());
		institution.setIt_city(instituteDTO.getDto_city());
		institution.setIt_address(instituteDTO.getDto_address());
		institution.setIt_zipCode(instituteDTO.getDto_zipCode());
		institution.setIt_telephoneOne(instituteDTO.getDto_telephoneOne());
		institution.setIt_telephoneTwo(instituteDTO.getDto_telephoneTwo());
		institution.setIt_email(instituteDTO.getDto_email());
		institution.setIt_directorsName(instituteDTO.getDto_directorsName());


		Institution newInstitution = intituteReposiortyI.save(institution);

		return mapearDTO(newInstitution);

	}

	@Override
	public void deleteInstitute(long id) {
		
		Institution institution = intituteReposiortyI.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Institucion", "id", id));

		intituteReposiortyI.delete(institution);
		
		
	}

}
