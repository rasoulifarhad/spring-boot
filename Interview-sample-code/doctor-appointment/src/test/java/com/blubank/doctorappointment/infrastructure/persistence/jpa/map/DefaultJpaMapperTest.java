package com.blubank.doctorappointment.infrastructure.persistence.jpa.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blubank.doctorappointment.domain.model.Patient.Patient;
import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;
import com.blubank.doctorappointment.domain.shared.Name;
import com.blubank.doctorappointment.domain.shared.PhoneNumber;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.patient.PatientJpaEntity;

@SpringBootTest
public class DefaultJpaMapperTest {

	@Autowired
	DefaultJpaMapper mapper;

	@Test
	public void mapJpaToPatientTest() {
		UUID uuid = UUID.randomUUID();
		PatientJpaEntity p = PatientJpaEntity.builder()
			.id(uuid.toString())
			.firstname("first #1")
			.lastname("last #1")
			.phoneNumber(PhoneNumber.of("123456"))
			.build();

		System.out.println(p);
		// Patient patient = DefaultJpaMapper.MAPPER.toPatient(p);
		Patient patient = mapper.toPatient(p);
				
		assertThat(patient.getName().getFirstname()).isEqualTo("first #1");
		assertThat(patient.getName().getLastname()).isEqualTo("last #1");
		assertThat(patient.getId().getUuid().toString()).isEqualTo(uuid.toString());
	}

	@Test
	public void mapPatientToJpaTest() {
		PatientId id = PatientId.newId();
		Patient patient = Patient.builder()
			.id(id)
			.name(Name.builder()
						.firstname("first #1")
						.lastname("last #1")
						.build())
			.phoneNumber(PhoneNumber.of("123456"))
			.build();
		// PatientJpaEntity patientJpaEntity = DefaultJpaMapper.MAPPER.fromPatient(patient);
		PatientJpaEntity patientJpaEntity = mapper.fromPatient(patient);
				
		assertThat(patientJpaEntity.getFirstname()).isEqualTo("first #1");
		assertThat(patientJpaEntity.getLastname()).isEqualTo("last #1");
		assertThat(patientJpaEntity.getId()).isEqualTo(id.toString());
	}

}
