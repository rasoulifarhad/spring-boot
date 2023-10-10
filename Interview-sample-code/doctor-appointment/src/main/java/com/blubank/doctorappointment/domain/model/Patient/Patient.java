package com.blubank.doctorappointment.domain.model.Patient;

import java.util.UUID;

import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;
import com.blubank.doctorappointment.domain.shared.Identifier;
import com.blubank.doctorappointment.domain.shared.Name;
import com.blubank.doctorappointment.domain.shared.PhoneNumber;
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
public class Patient implements AggregateRoot<PatientId>{
	
	private PatientId id;
	private PhoneNumber phoneNumber;
	private Name name;

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	@Value
	public static class PatientId implements Identifier {

		private final UUID uuid;

		public static PatientId newId() {
			return new PatientId(UUID.randomUUID());
		}

		public static PatientId from(String uuid) {
			return new PatientId(UUID.fromString(uuid));
		}
	}
}
