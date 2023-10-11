package com.blubank.doctorappointment.infrastructure.persistence.jpa.map;

import org.mapstruct.Mapper;

import com.blubank.doctorappointment.domain.model.Doctor.Doctor.DoctorId;
import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;
import com.blubank.doctorappointment.domain.model.appointment.Appointment.AppointmentId;

@Mapper(componentModel = "spring")
public class CommonMapStructConverters {
	
	public PatientId mapIdToPatientId(String id) {
		if(id == null || id.trim() == null) {
			return null;
		}
		return PatientId.from(id);
	}

	public String mapPatientIdToId(PatientId id) {
		if(id == null) {
			return null;
		}
		return id.getUuid().toString();
	}

	public DoctorId mapIdToDoctorId(String id) {
		if(id == null || id.trim() == null) {
			return null;
		}
		return DoctorId.from(id);
	}

	public String mapDoctorIdToId(DoctorId id) {
		if(id == null) {
			return null;
		}
		return id.getUuid().toString();
	}

	public AppointmentId mapIdToAppointmentId(String id) {
		if(id == null || id.trim() == null) {
			return null;
		}
		return AppointmentId.from(id);
	}

	public String mapAppointmentIdToId(AppointmentId id) {
		if(id == null) {
			return null;
		}
		return id.getUuid().toString();
	}

}
