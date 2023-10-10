package com.blubank.doctorappointment.domain.model.Doctor;

import java.util.UUID;

import com.blubank.doctorappointment.domain.model.Doctor.Doctor.DoctorId;
import com.blubank.doctorappointment.domain.shared.Identifier;
import com.blubank.doctorappointment.domain.shared.Name;
import com.blubank.doctorappointment.domain.shared.ddd.AggregateRoot;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Doctor implements AggregateRoot<DoctorId>{
	
	private DoctorId id;
	private Name name;

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class DoctorId implements Identifier {

		private final UUID uuid;

		public static DoctorId newId() {
			return new DoctorId(UUID.randomUUID());
		}

		public static DoctorId from(String uuid) {
			return new DoctorId(UUID.fromString(uuid));
		}
	}
}
