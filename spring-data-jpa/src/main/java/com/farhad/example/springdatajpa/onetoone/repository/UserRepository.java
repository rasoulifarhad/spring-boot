package com.farhad.example.springdatajpa.onetoone.repository;

import org.springframework.data.repository.CrudRepository;

import com.farhad.example.springdatajpa.onetoone.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
    
}
