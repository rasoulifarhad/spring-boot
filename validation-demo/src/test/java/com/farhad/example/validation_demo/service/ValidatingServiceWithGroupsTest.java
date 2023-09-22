package com.farhad.example.validation_demo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.farhad.example.validation_demo.InputWithGroups;

@SpringBootTest
public class ValidatingServiceWithGroupsTest {

    @Autowired
    private ValidatingServiceWithGroups service;

    @Test
    public void whenInputIsInvalidForCreate_thenThrowsException() {
        InputWithGroups input = validInputWithGroups();
        input.setId(42L);

        assertThrows(ConstraintViolationException.class,
                    () -> service.validateForCreate(input));
    }

    @Test
    public void whenInputIsInvalidForUpdate_thenThrowsException() {
        InputWithGroups input = validInputWithGroups();

        assertThrows(ConstraintViolationException.class,
                    () -> service.validateForUpdate(input));
    }


    @Test
    public void whenInputIsValidForCreate_thenNotThrowsException() {
        InputWithGroups input = validInputWithGroups();

        service.validateForCreate(input);
    }

    @Test
    public void whenInputIsValidForUpdate_thenNotThrowsException() {
        InputWithGroups input = validInputWithGroups();
        input.setId(42L);

        service.validateForUpdate(input);
    }



    private InputWithGroups validInputWithGroups() {
        InputWithGroups input = new InputWithGroups();
        input.setIpAddress("255.255.255.255");
        input.setNumberBetweenOneAndTen(10);
        return input;
    }   

}
