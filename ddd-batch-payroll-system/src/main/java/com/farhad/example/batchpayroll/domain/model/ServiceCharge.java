package com.farhad.example.batchpayroll.domain.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ServiceCharge {
    
    private LocalDate date;
    private double charge;

}
