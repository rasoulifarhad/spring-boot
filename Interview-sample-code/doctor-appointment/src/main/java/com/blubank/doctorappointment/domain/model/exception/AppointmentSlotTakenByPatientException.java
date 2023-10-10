package com.blubank.doctorappointment.domain.model.exception;

public class AppointmentSlotTakenByPatientException extends BusinessException {

	public AppointmentSlotTakenByPatientException(String code) {
		super(code);
	}
	
}
