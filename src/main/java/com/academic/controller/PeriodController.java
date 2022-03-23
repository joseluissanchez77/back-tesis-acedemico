package com.academic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.dto.PeriodDTO;
import com.academic.service.PeriodServiceI;

@RestController
@RequestMapping("/api/period")
public class PeriodController {

	@Autowired
	private PeriodServiceI periodServiceI;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping()
	public ResponseEntity<PeriodDTO> savePeriod(@RequestBody PeriodDTO periodDTO) {
		return new ResponseEntity<>(periodServiceI.createPeriod(periodDTO), HttpStatus.CREATED);
	}

}
