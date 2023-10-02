package com.farhad.example.ddd_hexagonal_spring_data.application.service;

import com.farhad.example.ddd_hexagonal_spring_data.application.repository.UserRepository;
import com.farhad.example.ddd_hexagonal_spring_data.domain.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UserService {
    
    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id);
    }
    
    public User saveUser(User user) {

        return userRepository.save(user);
    
      }    
}
