package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.mapper;

import org.mapstruct.Mapper;

import com.farhad.example.ddd_hexagonal_spring_data.domain.User;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.UserEntity;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    
    User toDomain(UserEntity userEntity);
    UserEntity toDbo(User user);
}
