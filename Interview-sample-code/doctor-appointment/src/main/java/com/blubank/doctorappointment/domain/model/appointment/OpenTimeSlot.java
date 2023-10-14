package com.blubank.doctorappointment.domain.model.appointment;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class OpenTimeSlot extends TimeSlot {

	public OpenTimeSlot(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		super(dayOfWeek, startTime, endTime);
		//TODO Auto-generated constructor stub
	}
	
}
