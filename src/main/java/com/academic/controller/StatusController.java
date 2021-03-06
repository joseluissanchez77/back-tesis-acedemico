package com.academic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.dto.ResponseDetailsDTO;
import com.academic.dto.StatusDTO;
import com.academic.service.StatusServiceI;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/state")
public class StatusController {

	@Autowired
	private StatusServiceI statusServiceI;
	
	
	@GetMapping
	public List<StatusDTO> listStatus(){
		return statusServiceI.getAllStatus();
	}
	
	@PostMapping
	public ResponseEntity<StatusDTO> saveStatus(@Valid @RequestBody StatusDTO statusDTO) {
		return new ResponseEntity<>(statusServiceI.createStatus(statusDTO), HttpStatus.CREATED);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<StatusDTO> getByIdStatus(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(statusServiceI.getStatusById(id));
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<StatusDTO> updateStatus(@Valid @RequestBody StatusDTO statusDTO,
			@PathVariable(name = "id") long id) {
		StatusDTO statusDTOResponse= statusServiceI.updateStatus(statusDTO, id);
		return new ResponseEntity<>(statusDTOResponse, HttpStatus.OK);
	}
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDetailsDTO> deleteStatus(@PathVariable(name = "id") long id) {
		ResponseDetailsDTO responseDetailsDTO = statusServiceI.deleteStatus(id);
		return new ResponseEntity<>(responseDetailsDTO, HttpStatus.OK);

	}
}
