package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.mapper.invoice;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.Product;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    @InheritInverseConfiguration
    ProductEntity toDbo(Product product);

    @Mapping(target="id", source="id")
    @Mapping(target="name", source="name")
    Product toDomain(ProductEntity productEntity);

}
