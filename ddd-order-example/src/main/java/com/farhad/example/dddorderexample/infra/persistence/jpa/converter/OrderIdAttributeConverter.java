package com.farhad.example.dddorderexample.infra.persistence.jpa.converter;

import com.farhad.example.dddorderexample.domain.model.Order.OrderId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class OrderIdAttributeConverter implements AttributeConverter<String, OrderId>{

    @Override
    public OrderId convertToDatabaseColumn(String dbData) {
        return dbData == null ? null : OrderId.of(dbData);
    }

    @Override
    public String convertToEntityAttribute(OrderId attribute) {
        return attribute == null ? null : attribute.getValue();
    }

}
