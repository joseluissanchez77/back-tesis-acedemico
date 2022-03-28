package com.academic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.academic.dto.PeriodDTO;
import com.academic.dto.PeriodResponse;
import com.academic.service.PeriodServiceI;
import com.academic.util.AppConstants;

@RestController
@RequestMapping("/api/period")
public class PeriodController {

	@Autowired
	private PeriodServiceI periodServiceI;
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public PeriodResponse listAllPeriod(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int numberPage,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_DEFAULT, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_ADDRESS_BY_DEFAULT, required = false) String sortDir) {
		return periodServiceI.getAllPeriod(numberPage, pageSize, sortBy, sortDir);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping()
	public ResponseEntity<PeriodDTO> savePeriod(@RequestBody PeriodDTO periodDTO) {
		return new ResponseEntity<>(periodServiceI.createPeriod(periodDTO), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PeriodDTO> getByIdPeriod(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(periodServiceI.getAllPeriodById(id));
	}
	
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<PeriodDTO> updatePeriod(@RequestBody PeriodDTO periodDTO,
			@PathVariable(name = "id") long id) {
		PeriodDTO periodDtoResponse = periodServiceI.updatePeriod(periodDTO, id);
		return new ResponseEntity<>(periodDtoResponse, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePeriod(@PathVariable(name = "id") long id) {
		periodServiceI.deletePeriod(id);
		return new ResponseEntity<>("Periodo borrado", HttpStatus.OK);

	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/change/{id}")
	public ResponseEntity<PeriodDTO> updateStatusPeriod(@RequestBody PeriodDTO periodDTO,
			@PathVariable(name = "id") long id) {
		PeriodDTO periodDtoResponse = periodServiceI.updateStatusPeriod(periodDTO, id);
		return new ResponseEntity<>(periodDtoResponse, HttpStatus.OK);
	}


}
