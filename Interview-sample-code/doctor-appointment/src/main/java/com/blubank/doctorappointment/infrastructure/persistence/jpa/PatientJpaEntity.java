package com.blubank.doctorappointment.infrastructure.persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@GeneratedValue
	private String id;
	private String name;
	private String phoneNumber;
}
