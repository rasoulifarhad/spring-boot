package com.farhad.example.valueobjectsdemo.domain;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, User.ID> {
    
    Optional<User> findByPhoneNumber(@NotNull PhoneNumber phoneNumber);

    List<User> findByNameLike(String name);
}
