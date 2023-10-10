package com.blubank.doctorappointment.domain.shared;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import com.blubank.doctorappointment.domain.shared.ddd.ValueObject;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Embeddable
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Value
public class Name implements ValueObject<Name> {

	@NonNull
	@NotBlank
	private final String firstname;

	@NonNull
	@NotBlank
	private final String lastname;


}
