package com.farhad.example.valueobjectsdemo.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@AllArgsConstructor
@Value
@EqualsAndHashCode(callSuper = false)
public class Passport {

    private PassportSeries  series;
    private PassportNumber number;
}
