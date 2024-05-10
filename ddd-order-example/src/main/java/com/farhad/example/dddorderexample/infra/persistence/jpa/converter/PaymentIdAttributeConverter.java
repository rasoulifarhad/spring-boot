package com.farhad.example.dddorderexample.infra.persistence.jpa.converter;

import com.farhad.example.dddorderexample.domain.model.Payment.PaymentId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PaymentIdAttributeConverter implements AttributeConverter<String, PaymentId>{

    @Override
    public PaymentId convertToDatabaseColumn(String dbData) {
        return dbData == null ? null : PaymentId.of(dbData);
    }

    @Override
    public String convertToEntityAttribute(PaymentId attribute) {
        return attribute == null ? null : attribute.getValue();
    }

}