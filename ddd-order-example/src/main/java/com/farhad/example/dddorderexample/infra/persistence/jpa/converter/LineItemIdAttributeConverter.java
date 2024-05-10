package com.farhad.example.dddorderexample.infra.persistence.jpa.converter;

import com.farhad.example.dddorderexample.domain.model.LineItem.LineItemId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class LineItemIdAttributeConverter implements AttributeConverter<String, LineItemId>{

    @Override
    public LineItemId convertToDatabaseColumn(String dbData) {
        return dbData == null ? null : LineItemId.of(dbData);
    }

    @Override
    public String convertToEntityAttribute(LineItemId attribute) {
        return attribute == null ? null : attribute.getValue();
    }

}
