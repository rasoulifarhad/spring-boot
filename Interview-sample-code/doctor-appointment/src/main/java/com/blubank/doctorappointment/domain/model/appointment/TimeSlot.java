package com.blubank.doctorappointment.domain.model.appointment;

import java.time.LocalTime;

import com.blubank.doctorappointment.domain.shared.ddd.ValueObject;

public interface TimeSlot extends ValueObject<TimeSlot>{
	
	LocalTime start();
	LocalTime end();

}
