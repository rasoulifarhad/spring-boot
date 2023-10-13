package com.blubank.doctorappointment.infrastructure.persistence.jpa.patient;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.blubank.doctorappointment.domain.model.Patient.Patient;
import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;
import com.blubank.doctorappointment.domain.model.Patient.PatientRepository;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.map.PatientJpaMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PatientRepositoryImple implements PatientRepository {
	
	private final SpringDataPatientRepository repository;
	private final PatientJpaMapper mapper;

	@Override
	public Patient save(Patient patient) {
		return mapper.toPatient(
					repository.save(
							mapper.fromPatient(patient)));
	}

	@Override
	public Optional<Patient> findById(PatientId id) {
		return 
			repository
				.findById(id
					.getUuid()
					.toString())
				.map(mapper::toPatient);
	}
}
