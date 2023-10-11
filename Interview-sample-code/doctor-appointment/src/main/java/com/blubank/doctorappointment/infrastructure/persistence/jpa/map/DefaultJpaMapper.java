package com.blubank.doctorappointment.infrastructure.persistence.jpa.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blubank.doctorappointment.domain.model.Doctor.Doctor;
import com.blubank.doctorappointment.domain.model.Patient.Patient;
import com.blubank.doctorappointment.domain.model.appointment.Appointment;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.appointment.AppointmentJpaEntity;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.doctor.DoctorJpaEntity;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.patient.PatientJpaEntity;

@Mapper(componentModel = "spring", uses = CommonMapStructConverters.class)
public interface DefaultJpaMapper {

	@Mapping(source = "firstname", target = "name.firstname")
	@Mapping(source = "lastname", target = "name.lastname")
	Patient convert(PatientJpaEntity jpaEntity) ;
	Doctor convert(DoctorJpaEntity jpaEntity) ;
	Appointment convert(AppointmentJpaEntity jpaEntity) ; 

}
