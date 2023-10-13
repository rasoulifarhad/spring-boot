package com.blubank.doctorappointment.domain.model.appointment;

import java.time.LocalDate;
import java.util.List;

public class DaySlot {
	
	private LocalDate day;
	private List<TimeSlot> allSlots;

	private List<TimeSlot> openSlots;
	private List<TimeSlot> takenSlots;

}
