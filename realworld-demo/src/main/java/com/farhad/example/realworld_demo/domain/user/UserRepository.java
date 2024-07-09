package com.farhad.example.realworld_demo.domain.user;

import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long>{

    User save(User user);
    Optional<User> findById(long id);
    Optional<User> findFirstByProfileUserName(UserName userName);
}
