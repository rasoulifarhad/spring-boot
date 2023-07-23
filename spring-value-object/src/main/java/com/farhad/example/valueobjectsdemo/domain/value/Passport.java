package com.farhad.example.valueobjectsdemo.domain.value;

import com.farhad.example.valueobjectsdemo.domain.exception.PassportParsingException;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class Passport {

    private PassportSeries  series;
    private PassportNumber number;

    public Passport(PassportSeries passportSeries, PassportNumber passportNumber) {
        this.number = passportNumber;
        this.series = passportSeries;
    }

    @Override
    public String toString() {
        return series.toString() + number.toString();
    }

    public static Passport parse(String value) {
        if (value == null) {
            throw new PassportParsingException("Passport value cannot be null");
        }

        String trimmed = value.trim();
        if (trimmed.length() != 10) {
            throw new PassportParsingException("Invalid passport value. Should contain 10 characters but it is: " + trimmed);
        }
        return new Passport(
            PassportSeries.parse(value.substring(0, 4)),
            PassportNumber.parse(value.substring(4))
        );
    }
}
