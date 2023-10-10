package com.blubank.doctorappointment.domain.model.appointment;

import java.util.HashSet;
import java.util.Set;

import com.blubank.doctorappointment.domain.shared.ddd.ValueObject;

public class TimeSlots implements ValueObject<TimeSlots> {

	Set<TimeSlot> timeSlots = new HashSet<>();

	public void add(TimeSlot timeSlot) {

	}
}
