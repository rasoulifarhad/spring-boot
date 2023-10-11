package com.blubank.doctorappointment.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blubank.doctorappointment.infrastructure.persistence.jpa.patient.PatientJpaEntity;

public interface SpringDataPatientRepository extends JpaRepository<PatientJpaEntity, String> {
	
}
