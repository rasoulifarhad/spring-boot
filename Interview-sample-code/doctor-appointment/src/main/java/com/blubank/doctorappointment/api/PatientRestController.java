package com.blubank.doctorappointment.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blubank.doctorappointment.api.dto.CreatePatientRequestDTO;
import com.blubank.doctorappointment.api.dto.CreatePatientResponseDTO;
import com.blubank.doctorappointment.application.CreatePatientUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientRestController {
	

	private final CreatePatientUseCase createPatientUseCase;

	@PostMapping
	public ResponseEntity<CreatePatientResponseDTO> createPatient(@RequestBody CreatePatientRequestDTO request) {
		return 
			new ResponseEntity<>(
					createPatientUseCase.createPatient(request),
					HttpStatus.CREATED);
	}
}
