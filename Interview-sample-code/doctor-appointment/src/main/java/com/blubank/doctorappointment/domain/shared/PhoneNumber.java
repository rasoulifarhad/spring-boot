package com.blubank.doctorappointment.domain.shared;

import com.blubank.doctorappointment.domain.shared.ddd.ValueObject;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
@Value
public class PhoneNumber implements ValueObject<PhoneNumber> {
	
	@NonNull
	private final String value;

	public static PhoneNumber of(String value) {
		if(value == null || value.trim() == null ) {
			return null;
		}
		return new PhoneNumber(value);
	}
}
