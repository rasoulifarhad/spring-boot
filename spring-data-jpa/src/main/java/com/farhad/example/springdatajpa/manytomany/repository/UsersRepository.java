package com.farhad.example.springdatajpa.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springdatajpa.manytomany.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    
}
