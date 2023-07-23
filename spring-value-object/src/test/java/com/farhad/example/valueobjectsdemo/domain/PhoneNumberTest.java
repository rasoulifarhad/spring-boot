package com.farhad.example.valueobjectsdemo.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PhoneNumberTest {

    @ParameterizedTest
    @CsvSource({
        "78005553535,178005553535",
        "88005553535,188005553535",
    })
    public void testPhoneNumber(String input, String expectedOutput) {
        PhoneNumber phoneNumber = new PhoneNumber(input);
        assertEquals(expectedOutput, phoneNumber.getValue());
    }

    @ParameterizedTest
    @CsvSource({
        "78005553535,9878005553535,IR",
        "88005553535,9888005553535,IR",
    })
    public void testPhoneNumberWithDefaultRegion(String input, String expectedOutput, String defaultRegion) {
        PhoneNumber phoneNumber = new PhoneNumber(input, defaultRegion);
        assertEquals(expectedOutput, phoneNumber.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-56"})
    public void shouldThrowException(String input) {
        assertThrows(PhoneNumberParsingException.class,
                      () -> new PhoneNumber(input));
    }
}
