package com.farhad.example.valueobjectsdemo.domain.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.value.Passport;
import com.farhad.example.valueobjectsdemo.domain.value.PhoneNumber;

public interface UserRepository extends JpaRepository<User, User.ID> {
    
    Optional<User> findByPhoneNumber(@NotNull PhoneNumber phoneNumber);

    @Query( "select u.passport from User u where u.id = :id")
    Optional<Passport> findPassportById(User.ID id);

    @Query( value = "select * from users WHERE name like :name",
            nativeQuery = true
    )
    List<User> findByNameLike(String name);
}
