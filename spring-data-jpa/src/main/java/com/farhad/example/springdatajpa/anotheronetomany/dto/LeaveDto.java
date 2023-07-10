package com.farhad.example.springdatajpa.anotheronetomany.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LeaveDto {
   
    private Long id;
    private String dayOfWeek;
    private LocalDate dateTaken;
    
}
