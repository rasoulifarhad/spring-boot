package com.farhad.example.validation_demo.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import com.farhad.example.validation_demo.Input;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammaticallyValidatingService {
    
    private Validator validator; 

    public void validateInput(Input input) {
        ValidatorFactory factory =Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Input>> violations = validator.validate(input);
        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public void validateInputWithInjectedValidator(Input input) {
        Set<ConstraintViolation<Input>> violations = validator.validate(input);
        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
