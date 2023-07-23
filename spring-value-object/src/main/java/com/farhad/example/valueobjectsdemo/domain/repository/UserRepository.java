package com.farhad.example.valueobjectsdemo.domain.repository;

import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.value.PhoneNumber;

public interface UserRepository extends JpaRepository<User, UUID> {
    
    Optional<User> findByPhoneNumber(@NotNull PhoneNumber phoneNumber);

    // Optional<Passport> findPassportById(User.ID id);
    // List<User> findByNameLike(String name);
}
