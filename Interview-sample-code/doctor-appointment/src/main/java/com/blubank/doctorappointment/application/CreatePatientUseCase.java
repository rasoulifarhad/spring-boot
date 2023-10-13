package com.blubank.doctorappointment.application;

import com.blubank.doctorappointment.api.dto.CreatePatientRequestDTO;
import com.blubank.doctorappointment.api.dto.CreatePatientResponseDTO;

public interface CreatePatientUseCase {
	
	public CreatePatientResponseDTO createPatient(CreatePatientRequestDTO request);
}
