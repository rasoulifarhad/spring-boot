package com.farhad.example.valueobjectsdemo.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.farhad.example.valueobjectsdemo.domain.value.Passport;

@Converter
public class PassportConverter implements AttributeConverter<Passport, String> {

    @Override
    public String convertToDatabaseColumn(Passport attribute) {
        return attribute.toString();
    }

    @Override
    public Passport convertToEntityAttribute(String dbData) {
        return Passport.parse(dbData);
    }
    
}
