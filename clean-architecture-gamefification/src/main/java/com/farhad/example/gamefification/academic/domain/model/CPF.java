package com.farhad.example.gamefification.academic.domain.model;

import java.util.Objects;

import com.farhad.example.gamefification.academic.domain.exception.InvalidCpfException;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "number")
public class CPF {

    private final String number;

    public CPF(String number) {
        Objects.requireNonNull(number);
        if(!number.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\{2}")) {
            throw new InvalidCpfException("CPF document it's not valid!");
        }
        this.number = number;
    }

    
}
