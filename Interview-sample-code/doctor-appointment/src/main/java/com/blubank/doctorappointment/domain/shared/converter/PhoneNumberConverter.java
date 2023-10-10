package com.blubank.doctorappointment.domain.shared.converter;

import javax.persistence.AttributeConverter;

import com.blubank.doctorappointment.domain.shared.PhoneNumber;

// @Converter(autoApply = true)
public class PhoneNumberConverter implements AttributeConverter<PhoneNumber, String> {

	@Override
	public String convertToDatabaseColumn(PhoneNumber attribute) {
		return attribute == null ? null : attribute.getValue();
	}

	@Override
	public PhoneNumber convertToEntityAttribute(String dbData) {
		return dbData == null ? null : new PhoneNumber(dbData); 
	}

	
}
