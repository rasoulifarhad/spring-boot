package com.blubank.doctorappointment.infrastructure.persistence.jpa.map;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.blubank.doctorappointment.domain.CommonMapStructConverters;
import com.blubank.doctorappointment.domain.model.appointment.Appointment;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.appointment.AppointmentJpaEntity;

@Mapper(componentModel = "spring", uses = CommonMapStructConverters.class,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
// @Mapper(uses = CommonMapStructConverters.class)
public interface AppointmentJpaMapper { 


	Appointment toAppointment(AppointmentJpaEntity jpaEntity) ; 

	AppointmentJpaEntity fromAppointment(Appointment appointment) ; 

}
