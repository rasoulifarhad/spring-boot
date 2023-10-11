package com.blubank.doctorappointment.domain.model.Patient;

import java.util.UUID;

import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;
import com.blubank.doctorappointment.domain.shared.Identifier;
import com.blubank.doctorappointment.domain.shared.Name;
import com.blubank.doctorappointment.domain.shared.PhoneNumber;
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
public class Patient extends BaseAggregateRoot<PatientId>{
	
	private PhoneNumber phoneNumber;
	
	private Name name;

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class PatientId implements Identifier {

		private final UUID uuid;

		
		public PatientId(@NonNull String uuidString) {
			this(UUID.fromString(uuidString));
		}

		public static PatientId newId() {
			return new PatientId(UUID.randomUUID());
		}

		public static PatientId from(String uuid) {
			return new PatientId(UUID.fromString(uuid));
		}
	}
}
