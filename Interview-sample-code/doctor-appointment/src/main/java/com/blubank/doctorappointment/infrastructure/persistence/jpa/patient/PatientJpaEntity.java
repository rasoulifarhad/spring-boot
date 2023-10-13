package com.blubank.doctorappointment.infrastructure.persistence.jpa.patient;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.blubank.doctorappointment.domain.shared.PhoneNumber;
import com.blubank.doctorappointment.domain.shared.converter.PhoneNumberConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientJpaEntity extends AbstractPersistable<String> {
	
	@Column(name = "name_first")
	private String firstname;

	@Column(name = "name_last")
	private String lastname;

	@Convert(converter = PhoneNumberConverter.class)  //
	private PhoneNumber phoneNumber;
}
