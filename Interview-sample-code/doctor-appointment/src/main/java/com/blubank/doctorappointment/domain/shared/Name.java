package com.blubank.doctorappointment.domain.shared;

import javax.validation.constraints.NotBlank;

import com.blubank.doctorappointment.domain.shared.ddd.ValueObject;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@AllArgsConstructor
@Value
public class Name implements ValueObject {

	@NonNull
	@NotBlank
	private String firstname;

	@NonNull
	@NotBlank
	private String lastname;

}
