package com.blubank.doctorappointment.api.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class CreatePatientResponseDTO {

	private String id;
	private String name;
	private String family;
	private String phoneNumber;
	private long version;

}
