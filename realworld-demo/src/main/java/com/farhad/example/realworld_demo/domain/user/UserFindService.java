package com.farhad.example.realworld_demo.domain.user;

import java.util.Optional;

public interface UserFindService {

    Optional<User> findById(long id);
    Optional<User> findByUsername(UserName userName);
}
