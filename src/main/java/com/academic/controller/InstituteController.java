package com.academic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academic.dto.InstituteDTO;
import com.academic.dto.InstituteResponse;
import com.academic.service.InstituteServiceI;
import com.academic.util.AppConstants;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {
	@Autowired
	private InstituteServiceI instituteServiceI;

	@GetMapping
	public InstituteResponse listInstitutes(
			// public List<InstituteDTO> listInstitutes(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int numberPage,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_DEFAULT, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_ADDRESS_BY_DEFAULT, required = false) String sortDir) {
		return instituteServiceI.getAllIntitute(numberPage, pageSize, sortBy, sortDir);
	}

	@GetMapping("/{id}")
	public ResponseEntity<InstituteDTO> getByIdInstitute(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(instituteServiceI.getAllIntituteById(id));
	}

//	@PostMapping( value ="/status/{statusId}",
//			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping()
	public ResponseEntity<InstituteDTO> saveInstitute(@RequestBody InstituteDTO instituteDTO) {
		return new ResponseEntity<>(instituteServiceI.createIsntitute(instituteDTO), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<InstituteDTO> updateInstitute(@RequestBody InstituteDTO instituteDTO,
			@PathVariable(name = "id") long id) {
		InstituteDTO instituteDtoResponse = instituteServiceI.updateIntitute(instituteDTO, id);
		return new ResponseEntity<>(instituteDtoResponse, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteIntitute(@PathVariable(name = "id") long id) {
		instituteServiceI.deleteInstitute(id);
		return new ResponseEntity<>("Intituto borrado", HttpStatus.OK);

	}
}
