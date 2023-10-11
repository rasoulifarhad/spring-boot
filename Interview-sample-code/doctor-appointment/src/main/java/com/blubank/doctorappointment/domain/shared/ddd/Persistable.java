package com.blubank.doctorappointment.domain.shared.ddd;

import org.springframework.lang.Nullable;

public interface Persistable<Id> {
	

	@Nullable
	Id getId();
}
