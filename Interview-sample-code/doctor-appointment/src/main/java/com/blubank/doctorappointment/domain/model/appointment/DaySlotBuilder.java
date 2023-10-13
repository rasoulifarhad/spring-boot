package com.blubank.doctorappointment.domain.model.appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.function.Consumer;

public class DaySlotBuilder {
	
	LocalDate day;
	LocalTime start;
	LocalTime end;
	Period slotDuration;

	public DaySlotBuilder dayOf(LocalDate day) {
		this.day = day;
		return this;
	}

	public DaySlotBuilder startAt(LocalTime start) {
		this.start = start;
		return this;
	}

	public DaySlotBuilder endAt(LocalTime end) {
		this.end = end;
		return this;
	}

	public DaySlotBuilder with(Period slotDuration  ) {
		this.slotDuration = slotDuration;
		return this;
	}

	public static void create(Consumer<DaySlot> consumer)
	
}
