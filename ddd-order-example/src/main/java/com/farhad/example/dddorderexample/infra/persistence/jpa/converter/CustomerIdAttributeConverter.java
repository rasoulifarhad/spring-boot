package com.farhad.example.dddorderexample.infra.persistence.jpa.converter;

import com.farhad.example.dddorderexample.domain.model.CustomerId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CustomerIdAttributeConverter  implements AttributeConverter<String, CustomerId>{

    @Override
    public CustomerId convertToDatabaseColumn(String dbData) {
        return dbData == null ? null : CustomerId.of(dbData);
    }

    @Override
    public String convertToEntityAttribute(CustomerId attribute) {
        return attribute == null ? null : attribute.getValue();
    }

}