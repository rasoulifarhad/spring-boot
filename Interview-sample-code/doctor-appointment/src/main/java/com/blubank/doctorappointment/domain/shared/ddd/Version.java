package com.blubank.doctorappointment.domain.shared.ddd;

import lombok.Value;

@Value
public class Version {
	
	int version;

	public static Version zero() {
		return new Version(0);
	}
}
