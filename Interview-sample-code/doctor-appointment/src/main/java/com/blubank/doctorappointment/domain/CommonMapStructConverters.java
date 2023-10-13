package com.blubank.doctorappointment.domain;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.blubank.doctorappointment.domain.model.Doctor.Doctor.DoctorId;
import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;
import com.blubank.doctorappointment.domain.model.appointment.Appointment.AppointmentId;
import com.blubank.doctorappointment.domain.shared.PhoneNumber;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
// @Mapper
public class CommonMapStructConverters {
	
	
	public PatientId toPatientId(String id) {
		if(id == null || id.trim() == null) {
			return null;
		}
		return PatientId.from(id);
	}

	public String fromPatientId(PatientId id) {

		if(id == null || id.getUuid() == null) {
			return null;
		}
		return id.getUuid().toString();
	}


	public DoctorId toDoctorId(String id) {
		if(id == null || id.trim() == null) {
			return null;
		}
		return DoctorId.from(id);
	}

	public String fromDoctorId(DoctorId id) {
		if(id == null || id.getUuid() == null) {
			return null;
		}
		return id.getUuid().toString();
	}

	public AppointmentId toAppointmentId(String id) {
		if(id == null || id.trim() == null) {
			return null;
		}
		return AppointmentId.from(id);
	}

	public String fromAppointmentId(AppointmentId id) {
		if(id == null || id.getUuid() == null) {
			return null;
		}
		return id.getUuid().toString();
	}

	public Long fromOptional(Optional<Long> optional) {
		if(optional.isPresent()) {
			return optional.get();
		} 
		return null;
	}

	public PhoneNumber toPhoneNumber(String value) {
		if(value == null || value.trim() == null) {
			return null;
		}
		return PhoneNumber.of(value);
	}

	public String fromPhoneNumber(PhoneNumber phoneNumber) {
		if(phoneNumber == null || phoneNumber.getValue() == null) {
			return null;
		}
		return phoneNumber.getValue();
	}

}
