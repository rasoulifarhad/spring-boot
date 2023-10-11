package com.blubank.doctorappointment.infrastructure.persistence.jpa.patient;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blubank.doctorappointment.domain.shared.PhoneNumber;
import com.blubank.doctorappointment.domain.shared.converter.PhoneNumberConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientJpaEntity {
	
	@Id
	@Column(name = "patient_id")
	private String id;

	@Column(name = "name_first")
	private String firstname;

	@Column(name = "name_last")
	private String lastname;

	@Convert(converter = PhoneNumberConverter.class)  //
	private PhoneNumber phoneNumber;
}
