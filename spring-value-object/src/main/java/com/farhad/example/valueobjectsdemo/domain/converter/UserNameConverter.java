package com.farhad.example.valueobjectsdemo.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.farhad.example.valueobjectsdemo.domain.User.Name;

@Converter
public class UserNameConverter implements AttributeConverter<Name, String>{

    @Override
    public String convertToDatabaseColumn(Name attribute) {
        return attribute.getValue();
    }

    @Override
    public Name convertToEntityAttribute(String dbData) {
        return new Name(dbData);
    }
    
}
