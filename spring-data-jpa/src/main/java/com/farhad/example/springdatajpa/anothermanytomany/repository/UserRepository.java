package com.farhad.example.springdatajpa.anothermanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.anothermanytomany.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
