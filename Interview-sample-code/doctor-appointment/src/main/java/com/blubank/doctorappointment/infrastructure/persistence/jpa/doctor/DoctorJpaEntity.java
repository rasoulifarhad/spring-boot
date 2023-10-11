package com.blubank.doctorappointment.infrastructure.persistence.jpa.doctor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorJpaEntity {
	
	@Id
	@Column(name = "doctor_id")
	private String id;
}
