package com.blubank.doctorappointment.infrastructure.persistence.jpa.appointment;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "appointments")
@Builder
public class AppointmentJpaEntity extends AbstractPersistable<String>  {
	
}
