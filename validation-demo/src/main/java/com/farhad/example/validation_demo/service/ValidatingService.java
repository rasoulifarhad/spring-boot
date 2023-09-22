package com.farhad.example.validation_demo.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.farhad.example.validation_demo.Input;
import com.farhad.example.validation_demo.InputWithCustomValidator;

@Service
@Validated
public class ValidatingService {
    
    void validateInput(@Valid Input input){

    }

    void validateInputWithCustomValidator(@Valid InputWithCustomValidator input){
        
    }
}
