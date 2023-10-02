package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.mapper.invoice;

import org.mapstruct.Mapper;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.Product;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    ProductEntity toDbo(Product product);
    Product toDomain(ProductEntity productEntity);

}
