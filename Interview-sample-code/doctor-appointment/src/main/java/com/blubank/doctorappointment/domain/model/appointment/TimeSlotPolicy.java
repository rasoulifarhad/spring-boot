package com.blubank.doctorappointment.domain.model.appointment;

import java.time.LocalTime;

public interface TimeSlotPolicy {
	
	LocalTime endTime(LocalTime start);
}
