package com.blubank.doctorappointment.application.impl;

import org.springframework.stereotype.Service;

import com.blubank.doctorappointment.api.assembler.PatientDtoMapper;
import com.blubank.doctorappointment.api.dto.CreatePatientRequestDTO;
import com.blubank.doctorappointment.api.dto.CreatePatientResponseDTO;
import com.blubank.doctorappointment.application.CreatePatientUseCase;
import com.blubank.doctorappointment.domain.model.Patient.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreatePatientService implements CreatePatientUseCase {

	private final PatientRepository patientRepository;
	private final PatientDtoMapper mapper;

	@Override
	public CreatePatientResponseDTO createPatient(CreatePatientRequestDTO request) {
		return mapper.fromPatient(
							patientRepository.save(
									mapper.toPatient(request)));

	}
	
}
