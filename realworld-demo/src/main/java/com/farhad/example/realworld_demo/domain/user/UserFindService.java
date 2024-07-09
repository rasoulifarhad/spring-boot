package com.farhad.example.realworld_demo.domain.user;

import java.util.Optional;

public interface UserFindService {

    Optional<User> findById(Long id);
    Optional<User> findByUsername(UserName userName);
}
