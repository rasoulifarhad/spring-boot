package com.farhad.example.validation_demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Entity
@Data
public class InputWithCustomValidator {
    
   @Id
    @GeneratedValue
    private Long id;

    @Min(1)
    @Max(10)
    private int numberBetweenOneAndTen;

    @IpAddress
    private String ipAddress;    
}
