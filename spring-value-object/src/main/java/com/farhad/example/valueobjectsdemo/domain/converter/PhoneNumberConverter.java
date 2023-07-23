package com.farhad.example.valueobjectsdemo.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.farhad.example.valueobjectsdemo.domain.value.PhoneNumber;

@Converter
public class PhoneNumberConverter implements AttributeConverter<PhoneNumber, String> {

    @Override
    public String convertToDatabaseColumn(PhoneNumber attribute) {
        return attribute.getValue();
    }

    @Override
    public PhoneNumber convertToEntityAttribute(String dbData) {
        return new PhoneNumber(dbData);
    }
    
}
