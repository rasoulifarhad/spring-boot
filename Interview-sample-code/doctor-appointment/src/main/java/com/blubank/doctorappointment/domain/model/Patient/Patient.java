package com.blubank.doctorappointment.domain.model.Patient;

import java.util.UUID;

import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;
import com.blubank.doctorappointment.domain.shared.Identifier;
import com.blubank.doctorappointment.domain.shared.Name;
import com.blubank.doctorappointment.domain.shared.PhoneNumber;
import com.blubank.doctorappointment.domain.shared.ddd.BaseAggregateRoot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Getter
@Setter(value = AccessLevel.PROTECTED)
// @NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Patient extends BaseAggregateRoot<PatientId>{
	
	@NonNull
	private PhoneNumber phoneNumber;
	
	@NonNull
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
			if(uuid == null || uuid.trim() == null ) {
				return null;
			}
			return new PatientId(UUID.fromString(uuid));
		}
	}

	public static void main(String[] args) {
		System.out.println(PatientId.from("882925c5-0e08-4ad7-8b51-2d2df4f15ffa"));
		System.out.println(PatientId.from(null));
	}
}
