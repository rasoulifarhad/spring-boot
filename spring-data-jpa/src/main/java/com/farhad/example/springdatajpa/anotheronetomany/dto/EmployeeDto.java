package com.farhad.example.springdatajpa.anotheronetomany.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    
    private Long id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private long emoluments;
}
