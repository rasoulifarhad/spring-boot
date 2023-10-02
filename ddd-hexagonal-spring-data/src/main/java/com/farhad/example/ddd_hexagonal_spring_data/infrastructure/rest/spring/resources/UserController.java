package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.rest.spring.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.ddd_hexagonal_spring_data.application.service.UserService;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.rest.spring.dto.UserDto;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.rest.spring.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return new ResponseEntity<UserDto>(userMapper.toDto(userService.getUser(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<UserDto>(userMapper.toDto(userService.saveUser(userMapper.toDiomain(userDto))), HttpStatus.OK);
    }
}
