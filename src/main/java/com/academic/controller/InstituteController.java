package com.academic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.dto.InstituteDTO;
import com.academic.service.InstituteServiceI;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {
	@Autowired
	private InstituteServiceI instituteServiceI;

	@PostMapping
	public ResponseEntity<InstituteDTO> saveInstitute(@RequestBody InstituteDTO instituteDTO) {
		return new ResponseEntity<>(instituteServiceI.createIsntitute(instituteDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public List<InstituteDTO> listInstitutes() {
		return instituteServiceI.getAllIntitute();
	}

	@GetMapping("/{id}")
	public ResponseEntity<InstituteDTO> getByIdInstitute(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(instituteServiceI.getAllIntituteById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<InstituteDTO> updateInstitute(@RequestBody InstituteDTO instituteDTO,
			@PathVariable(name = "id") long id) {
		InstituteDTO instituteDtoResponse = instituteServiceI.updateIntitute(instituteDTO, id);
		return new ResponseEntity<>(instituteDtoResponse, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteIntitute(@PathVariable(name = "id") long id){
		instituteServiceI.deleteInstitute(id);
		return new ResponseEntity<>("Intituto borrado",HttpStatus.OK);
		
	}
}
