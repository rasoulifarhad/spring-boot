package com.farhad.example.valueobjectsdemo.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.User.Name;
import com.farhad.example.valueobjectsdemo.domain.repository.UserRepository;
import com.farhad.example.valueobjectsdemo.domain.value.Passport;
import com.farhad.example.valueobjectsdemo.domain.value.PhoneNumber;
import com.farhad.example.valueobjectsdemo.domain.value.UserResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    
    private final UserRepository userRepository;

    @GetMapping("/api/users")
    public UserResponse byPhoneNumber(@RequestParam PhoneNumber phoneNumber) {
        User user =  userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new RuntimeException("Phone not found"  + phoneNumber));
        return new UserResponse(
            user.getId(),
            user.getPhoneNumber(),
            user.getPassport(),
            user.getName());
    }

    @PostMapping("/api/users")
    public void createUser(@RequestParam PhoneNumber phoneNumber, @RequestParam Passport passport, @RequestParam Name name) {

    }

}
