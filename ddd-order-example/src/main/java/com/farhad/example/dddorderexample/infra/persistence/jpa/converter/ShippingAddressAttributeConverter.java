package com.farhad.example.dddorderexample.infra.persistence.jpa.converter;

import com.farhad.example.dddorderexample.domain.model.ShippingAddress.ShippingAddressId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ShippingAddressAttributeConverter  implements AttributeConverter<String, ShippingAddressId>{

    @Override
    public ShippingAddressId convertToDatabaseColumn(String dbData) {
        return dbData == null ? null : ShippingAddressId.of(dbData);
    }

    @Override
    public String convertToEntityAttribute(ShippingAddressId attribute) {
        return attribute == null ? null : attribute.getValue();
    }

}