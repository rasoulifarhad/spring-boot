package com.farhad.example.dddbank.infrastructure.persistence.rest;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class TransferCommand {
   

    private final Long srcAccountNo;
    private final Long destAccountNo;
    private final double amout;
}
