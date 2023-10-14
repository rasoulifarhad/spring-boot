package com.blubank.doctorappointment.domain.model.appointment;

import java.time.DayOfWeek;
import java.time.LocalTime;

import com.blubank.doctorappointment.domain.shared.ddd.ValueObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class TimeSlot implements ValueObject<TimeSlot>{

	DayOfWeek dayOfWeek;
	LocalTime startTime;
	LocalTime endTime;

}
