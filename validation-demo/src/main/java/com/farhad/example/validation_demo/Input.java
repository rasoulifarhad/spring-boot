package com.farhad.example.validation_demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Input {
    
    @Id
    @GeneratedValue
    private Long id;

    @Min(1)
    @Max(10)
    private int numberBetweenOneAndTen;

    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    private String ipAddress;
}
