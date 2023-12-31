package com.blubank.doctorappointment.domain.model.Doctor;

import java.util.UUID;

import com.blubank.doctorappointment.domain.model.Doctor.Doctor.DoctorId;
import com.blubank.doctorappointment.domain.shared.Identifier;
import com.blubank.doctorappointment.domain.shared.Name;
import com.blubank.doctorappointment.domain.shared.ddd.BaseAggregateRoot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Getter
@Setter(value = AccessLevel.PRIVATE)
// @NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Doctor extends BaseAggregateRoot<DoctorId>{
	
	private Name name;

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class DoctorId implements Identifier {

		private final UUID uuid;
		public DoctorId(@NonNull String uuidString) {
			this(UUID.fromString(uuidString));
		}

		public static DoctorId newId() {
			return new DoctorId(UUID.randomUUID());
		}

		public static DoctorId from(String uuid) {
			if(uuid == null || uuid.trim() == null ) {
				return null;
			}
			return new DoctorId(UUID.fromString(uuid));
		}
	}
}
