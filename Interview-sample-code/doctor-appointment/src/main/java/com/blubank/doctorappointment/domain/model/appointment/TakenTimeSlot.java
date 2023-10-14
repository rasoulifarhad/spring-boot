package com.blubank.doctorappointment.domain.model.appointment;

import java.time.DayOfWeek;
import java.time.LocalTime;

import com.blubank.doctorappointment.domain.model.appointment.Appointment.AppointmentId;

public class TakenTimeSlot extends TimeSlot {

	AppointmentId appointmentId;
	
	public TakenTimeSlot(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, AppointmentId appointmentId) {
		super(dayOfWeek, startTime, endTime);
		this.appointmentId = appointmentId;
	}


	
}
