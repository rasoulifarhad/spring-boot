package com.farhad.example.validation_demo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.farhad.example.validation_demo.Input;
import com.farhad.example.validation_demo.InputWithCustomValidator;

@SpringBootTest
public class ValidatingServiceTest {

    @Autowired
    private ValidatingService validatingService;

    @Test
    void whenInputIsInvalid_thenThrowsException(){  
        Input input = invalidInput();
        
        assertThrows(ConstraintViolationException.class,
                        () -> validatingService.validateInput(input));
    }

    @Test
    void whenInputWithCustomValidatorIsInvalid_thenThrowsException(){  
        InputWithCustomValidator input = invalidInputWithCustomValidator();
        
        assertThrows(ConstraintViolationException.class,
                        () -> validatingService.validateInputWithCustomValidator(input));
    }    

    @Test
    void whenInputWithCustomValidatorIsvalid_thenOk(){  
        InputWithCustomValidator input = validInputWithCustomValidator();
        validatingService.validateInputWithCustomValidator(input)   ;     
    }    


    private Input invalidInput() {
        Input input = new Input();
        input.setIpAddress("invalid");
        input.setNumberBetweenOneAndTen(99);
        return input;
      }

    private Input validInput() {
        Input input = new Input();
        input.setIpAddress("255.255.255.255");
        input.setNumberBetweenOneAndTen(10);
        return input;
    }   
      
    private InputWithCustomValidator invalidInputWithCustomValidator() {
        InputWithCustomValidator inputWithCustomValidator = new InputWithCustomValidator();
        inputWithCustomValidator.setIpAddress("255.255.255.300");
        inputWithCustomValidator.setNumberBetweenOneAndTen(10);  
        return inputWithCustomValidator;      
    }

    private InputWithCustomValidator validInputWithCustomValidator() {
        InputWithCustomValidator inputWithCustomValidator = new InputWithCustomValidator();
        inputWithCustomValidator.setIpAddress("255.255.255.255");
        inputWithCustomValidator.setNumberBetweenOneAndTen(10);  
        return inputWithCustomValidator;      
    }

}
