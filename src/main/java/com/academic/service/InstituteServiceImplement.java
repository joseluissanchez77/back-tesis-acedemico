package com.academic.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.academic.dto.InstituteDTO;
import com.academic.dto.InstituteResponse;
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
	public InstituteResponse getAllIntitute(int pageNo,int pageSize,String sortBy, String sortDir) {
	//public List<InstituteDTO> getAllIntitute(int pageNo,int pageSize) {
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending() ;
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		Page<Institution> institutePage = intituteReposiortyI.findAll(pageable);
		
		//List<Institution> listOfInstitute = institutePage.getContent();//intituteReposiortyI.findAll();
		List<Institution> listOfInstitute = institutePage.getContent();//intituteReposiortyI.findAll();
		List<InstituteDTO>  contenido = listOfInstitute.stream().map(intitu -> mapearDTO(intitu)).collect(Collectors.toList());
		
		InstituteResponse instituteResponse = new InstituteResponse();
		instituteResponse.setContent(contenido);
		instituteResponse.setPageNo(institutePage.getNumber());
		instituteResponse.setPageSize(institutePage.getSize());
		instituteResponse.setTotalElement(institutePage.getTotalElements());
		instituteResponse.setTotalPage(institutePage.getTotalPages());
		instituteResponse.setLast(institutePage.isLast());
		
		return instituteResponse;

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
		instituteDTO.setCourse(institute.getCourses());


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
		institute.setStatus(instituteDTO.getDto_status_id());

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
		institution.setStatus(instituteDTO.getDto_status_id());


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
