package com.blubank.doctorappointment.infrastructure.persistence.jpa.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.blubank.doctorappointment.domain.model.Doctor.Doctor;
import com.blubank.doctorappointment.domain.model.Patient.Patient;
import com.blubank.doctorappointment.domain.model.appointment.Appointment;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.appointment.AppointmentJpaEntity;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.doctor.DoctorJpaEntity;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.patient.PatientJpaEntity;

@Mapper(componentModel = "spring", uses = CommonMapStructConverters.class,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
// @Mapper(uses = CommonMapStructConverters.class)
public interface DefaultJpaMapper {

    DefaultJpaMapper MAPPER = Mappers.getMapper( DefaultJpaMapper.class );	

	// @Mapping(source = "id", target = "name.firstname")
	@Mapping(source = "firstname", target = "name.firstname")
	@Mapping(source = "lastname", target = "name.lastname")
	Patient toPatient(PatientJpaEntity jpaEntity) ;

	@Mapping(source = "firstname", target = "name.firstname")
	@Mapping(source = "lastname", target = "name.lastname")
	Doctor toDoctor(DoctorJpaEntity jpaEntity) ;
	Appointment toAppointment(AppointmentJpaEntity jpaEntity) ; 

	// @Mapping(target = "id", source = "id.uuid")
	@Mapping(target = "firstname", source =  "name.firstname")
	@Mapping(target = "lastname", source = "name.lastname")
	PatientJpaEntity fromPatient(Patient patient) ;

	@Mapping(target = "firstname", source =  "name.firstname")
	@Mapping(target = "lastname", source = "name.lastname")
	DoctorJpaEntity fromDoctor(Doctor doctor) ;

	AppointmentJpaEntity fromAppointment(Appointment appointment) ; 

}
