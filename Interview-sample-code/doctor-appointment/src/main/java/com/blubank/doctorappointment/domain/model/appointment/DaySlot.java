package com.blubank.doctorappointment.domain.model.appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;
import java.util.function.Consumer;

public class DaySlot {
	
	private LocalDate day;

	private List<TimeSlot> allSlots;

	private List<TimeSlot> openSlots;
	private List<TimeSlot> takenSlots;

	public static DaySlotBuilder builder() {
		return new DaySlotBuilder();
	}

	public static class DaySlotBuilder {
	
		LocalDate day;
		LocalTime start;
		LocalTime end;
		Period slotDuration;

		private DaySlotBuilder() {

		}

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

		public static void create(Consumer<DaySlot> consumer) {
			DaySlot daySlot = new DaySlot();
			consumer.accept(daySlot);
			
		}
		
	}
}
