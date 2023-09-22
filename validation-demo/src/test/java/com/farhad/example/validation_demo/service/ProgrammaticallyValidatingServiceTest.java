package com.farhad.example.validation_demo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.farhad.example.validation_demo.Input;

@SpringBootTest
public class ProgrammaticallyValidatingServiceTest {
    
    @Autowired
    private ProgrammaticallyValidatingService service;

    private Input invalidInput() {
        Input input = new Input();
        input.setIpAddress("invalid");
        input.setNumberBetweenOneAndTen(99);
        return input;
    }

    @Test
    void whenInputIsInvalid_thenThrowsException(){
        Input input = invalidInput();

        assertThrows(ConstraintViolationException.class, 
                () -> service.validateInput(input));
    }

    @Test
    void givenInjectedValidator_whenInputIsInvalid_thenThrowsException(){
        Input input = invalidInput();
  
        assertThrows(ConstraintViolationException.class, () -> {
                        service.validateInputWithInjectedValidator(input);
        });
    }

    private Input validInput() {
        Input input = new Input();
        input.setIpAddress("255.255.255.255");
        input.setNumberBetweenOneAndTen(10);
        return input;
    }   

}
