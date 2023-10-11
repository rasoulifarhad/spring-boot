package com.blubank.doctorappointment.domain.model.appointment;

import java.util.UUID;

import com.blubank.doctorappointment.domain.model.appointment.Appointment.AppointmentId;
import com.blubank.doctorappointment.domain.shared.Identifier;
import com.blubank.doctorappointment.domain.shared.ddd.BaseAggregateRoot;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter(value = AccessLevel.PROTECTED)
// @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Appointment extends BaseAggregateRoot<AppointmentId> {

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class AppointmentId implements Identifier {

		private final UUID uuid;

		
		public AppointmentId(@NonNull String uuidString) {
			this(UUID.fromString(uuidString));
		}

		public static AppointmentId newId() {
			return new AppointmentId(UUID.randomUUID());
		}

		public static AppointmentId from(String uuid) {
			return new AppointmentId(UUID.fromString(uuid));
		}
	}
}
