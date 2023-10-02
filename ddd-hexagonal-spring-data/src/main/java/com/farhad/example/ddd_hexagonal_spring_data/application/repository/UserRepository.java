package com.farhad.example.ddd_hexagonal_spring_data.application.repository;

import com.farhad.example.ddd_hexagonal_spring_data.domain.model.user.User;

public interface UserRepository {
    User findById(Long id);
    User save(User user);
}
