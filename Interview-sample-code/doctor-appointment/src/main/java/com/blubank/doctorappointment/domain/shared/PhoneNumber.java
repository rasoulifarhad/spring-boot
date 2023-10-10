package com.blubank.doctorappointment.domain.shared;

import javax.persistence.Embeddable;

import com.blubank.doctorappointment.domain.shared.ddd.ValueObject;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
@Value
public class PhoneNumber implements ValueObject<PhoneNumber> {
	
	@NonNull
	private final String value;
}
