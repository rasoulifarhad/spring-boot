package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.mapper.invoice;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.LineItem;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice.LineItemEntity;

@Mapper(componentModel = "spring", uses = {ProductEntityMapper.class})
public interface LineItemEntityMapper {
    
    @InheritInverseConfiguration
    LineItemEntity toDbo(LineItem lineItem);
    
    @Mapping(target="product", source="product")
    @Mapping(target="quantity", source="quantity")
    LineItem toDomain(LineItemEntity lineItemEntity);
}
