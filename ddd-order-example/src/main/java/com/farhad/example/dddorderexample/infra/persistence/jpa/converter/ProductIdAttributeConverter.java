package com.farhad.example.dddorderexample.infra.persistence.jpa.converter;

import com.farhad.example.dddorderexample.domain.model.Product.ProductId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProductIdAttributeConverter implements AttributeConverter<String, ProductId>{

    @Override
    public ProductId convertToDatabaseColumn(String dbData) {
        return dbData == null ? null : ProductId.of(dbData);
    }

    @Override
    public String convertToEntityAttribute(ProductId attribute) {
        return attribute == null ? null : attribute.getValue();
    }

}