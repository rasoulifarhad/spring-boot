package com.blubank.doctorappointment.domain.model.appointment;

import java.util.UUID;

import com.blubank.doctorappointment.domain.model.appointment.Appointment.AppointmentId;
import com.blubank.doctorappointment.domain.shared.Identifier;
import com.blubank.doctorappointment.domain.shared.ddd.BaseAggregateRoot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter(value = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Appointment extends BaseAggregateRoot<AppointmentId> {

	@RequiredArgsConstructor
	@Value
	public static class AppointmentId implements Identifier {

		private final UUID uuid;
	}
}
