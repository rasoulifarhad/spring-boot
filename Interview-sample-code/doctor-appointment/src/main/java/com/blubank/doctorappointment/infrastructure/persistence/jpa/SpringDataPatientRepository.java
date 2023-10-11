package com.blubank.doctorappointment.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPatientRepository extends JpaRepository<PatientJpaEntity, String> {
	
}
