package com.blubank.doctorappointment.domain.model.Patient;

import java.util.Optional;

import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;

public interface PatientRepository {
	Patient save(Patient patient);
	Optional<Patient> findById(PatientId id);
}
