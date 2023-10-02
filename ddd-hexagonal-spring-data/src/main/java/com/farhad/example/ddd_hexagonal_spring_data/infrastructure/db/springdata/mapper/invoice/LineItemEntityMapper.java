package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.mapper.invoice;

import org.mapstruct.Mapper;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice.LineItem;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.invoice.LineItemEntity;

@Mapper(componentModel = "spring", uses = {ProductEntityMapper.class})
public interface LineItemEntityMapper {
    
    LineItemEntity toDbo(LineItem lineItem);
    
    LineItem toDomain(LineItemEntity lineItemEntity);
}
