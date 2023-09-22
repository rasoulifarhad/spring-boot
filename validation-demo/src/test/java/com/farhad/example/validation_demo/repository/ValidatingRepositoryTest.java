package com.farhad.example.validation_demo.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.farhad.example.validation_demo.Input;

@DataJpaTest
public class ValidatingRepositoryTest {

    @Autowired
    private ValidatingRepository validatingRepository;

    @Autowired
    private EntityManager entityManager; 
    
    @Test
    void whenInputIsInvalid_thenThrowsException() {
        Input input = invalidInput();

        assertThrows(ConstraintViolationException.class,
                        () -> {
                            validatingRepository.save(input);
                            entityManager.flush();
                        });
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
}
