package com.blubank.doctorappointment.domain.model.Patient;

import java.util.UUID;

import javax.persistence.Convert;
import javax.persistence.Embedded;

import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;
import com.blubank.doctorappointment.domain.shared.Identifier;
import com.blubank.doctorappointment.domain.shared.Name;
import com.blubank.doctorappointment.domain.shared.PhoneNumber;
import com.blubank.doctorappointment.domain.shared.converter.PhoneNumberConverter;
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
public class Patient extends BaseAggregateRoot<PatientId>{
	
	@Convert(converter = PhoneNumberConverter.class)  // <1>
	private PhoneNumber phoneNumber;
	
	@Embedded
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
