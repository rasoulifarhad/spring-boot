package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.repository;

import org.springframework.stereotype.Service;

import com.farhad.example.ddd_hexagonal_spring_data.application.repository.UserRepository;
import com.farhad.example.ddd_hexagonal_spring_data.domain.User;
import com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.mapper.UserEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service    
public class UserDboRepository implements UserRepository{

    private final SpringDataUserRepository userRepository;

    private final UserEntityMapper userMapper;
    
    @Override
    public User findById(Long id) {
        return userMapper.toDomain(
            userRepository
                .findById(id)
                .orElse(null));
    }

    @Override
    public User save(User user) {
        return userMapper.toDomain(userRepository.save(userMapper.toDbo(user)));
    }
    
}
