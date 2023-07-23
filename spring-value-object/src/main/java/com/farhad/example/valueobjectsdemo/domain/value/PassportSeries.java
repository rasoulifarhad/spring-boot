package com.farhad.example.valueobjectsdemo.domain.value;

import java.time.OffsetDateTime;
import java.time.Year;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.farhad.example.valueobjectsdemo.domain.exception.PassportSeriesParsingException;
import com.farhad.example.valueobjectsdemo.domain.exception.RegionParsingException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Valid
@EqualsAndHashCode(callSuper = false)
public class PassportSeries {

    @NotNull(message = "Passport series region cannot be null")
    private Region region;

    @NotNull(message = "Passport series year cannot be null")
    private Year year;

    public PassportSeries(Region region, Year year) {
        this.region = region;
        this.year = validateYear(year);
    }

    public static PassportSeries parse(String value) {
        if (value == null) {
            throw new PassportSeriesParsingException("Passport number value cannot be null");
        }
        String trimmed = value.trim();
        if(trimmed.length() != 4) {
            throw new PassportSeriesParsingException("Passport number value should have 4 characters but it's: " + trimmed);
        }

        return new PassportSeries(
                    Region.parse( value.substring(0, 2)), 
                    Year.parse("20" + value.substring(2)));
    }

    @Override
    public String toString() {
        return String.format("%02d%02d", region.getCode(), year.getValue() % 100);
    }

    private static String twoDigits(int value) {
        return value >= 10 ? String.valueOf(value) : "0" + value; 
    }
    
    private static Year validateYear(Year year) {
        Year currentYear = Year.of(OffsetDateTime.now().getYear());
        if (year.isBefore(Year.of(1991) ) || year.isAfter(currentYear) ) {
            throw new ConstraintViolationException(
                String.format(
                            "Year must be in range [1991, %s] but it's: %s",
                            currentYear, 
                            year), 
                null);
        }
        return year;        
    }

    @RequiredArgsConstructor
    @Getter
    public enum Region {
        KRASNODAR_KRAI(3),
        ALTAI_REPUBLIC(84);

        private final int code;

        public static Region parse(String value) {
            Integer code = Integer.parseInt(value);
            for (Region region : Region.values()) {
                if (region.getCode() == code) {
                    return region;
                }         
            }
            throw new RegionParsingException("Cannot parse Region from value: " + value);
        }
    }

}
