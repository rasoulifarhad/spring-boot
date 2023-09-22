package com.farhad.example.validation_demo.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.farhad.example.validation_demo.InputWithGroups;

@Service
@Validated
public class ValidatingServiceWithGroups {
    
    @Validated(OnCreate.class)
    public void validateForCreate(@Valid InputWithGroups input) {

    }

    @Validated(OnUpdate.class)
    public void validateForUpdate(@Valid InputWithGroups input) {

    }
}
