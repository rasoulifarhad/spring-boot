package com.farhad.example.dddbank.infrastructure.persistence.rest;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class AddAccountManagerCommand {
    
    private final Long acountNo;
    private final String userName;
}
