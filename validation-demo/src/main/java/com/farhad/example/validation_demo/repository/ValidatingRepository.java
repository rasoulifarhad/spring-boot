package com.farhad.example.validation_demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.farhad.example.validation_demo.Input;

public interface ValidatingRepository extends CrudRepository<Input, Long> {
    
}
