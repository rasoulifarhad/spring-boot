package com.blubank.doctorappointment.domain.model.exception;

public class NoOpenAppointmentSlotAvailableException extends BusinessException {

	public NoOpenAppointmentSlotAvailableException(String code) {
		super(code);
	}
	
}
