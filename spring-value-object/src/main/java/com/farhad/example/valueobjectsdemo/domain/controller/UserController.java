package com.farhad.example.valueobjectsdemo.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.valueobjectsdemo.domain.PhoneNumber;
import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    
    private final UserRepository userRepository;

    @GetMapping("/api/users")
    public User byPhoneNumber(@RequestParam PhoneNumber phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new RuntimeException("Phone not found"  + phoneNumber));
    }



}
