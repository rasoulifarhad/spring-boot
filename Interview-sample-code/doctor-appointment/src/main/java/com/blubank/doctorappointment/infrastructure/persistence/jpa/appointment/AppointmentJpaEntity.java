package com.blubank.doctorappointment.infrastructure.persistence.jpa.appointment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentJpaEntity {
	

	@Id
	@Column(name = "appointment_id")
	private String id;

}
