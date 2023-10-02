package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.rest.spring.mapper;

import org.mapstruct.Mapper;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.user.User;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.rest.spring.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDto toDto(User user);
    User toDiomain(UserDto userDto);
}
