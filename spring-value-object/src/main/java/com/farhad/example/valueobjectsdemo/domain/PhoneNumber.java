package com.farhad.example.valueobjectsdemo.domain;

import lombok.Value;

@Value
public class PhoneNumber {
    
    private static final PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();
    String value;

    public PhoneNumber(String value) {
        this.value = value;
        validatePhoneNumber(value);
    }

    private static void validatePhoneNumber(String value) {

        try {
            if (Long.parseLong(value) <= 0) {
                throw new PhoneNumberParsingException("The phone number must be positive: " + value);
            }
        } catch (Exception e) {
        }
    }

    
}
