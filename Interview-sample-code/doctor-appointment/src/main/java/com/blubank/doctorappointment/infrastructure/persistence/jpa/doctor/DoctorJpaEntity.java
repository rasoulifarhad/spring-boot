package com.blubank.doctorappointment.infrastructure.persistence.jpa.doctor;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "doctors")
@Builder
public class DoctorJpaEntity extends AbstractPersistable<String> {
	
}
