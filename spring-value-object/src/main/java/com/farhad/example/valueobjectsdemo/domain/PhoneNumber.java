package com.farhad.example.valueobjectsdemo.domain;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;

import lombok.Value;

@Value
public class PhoneNumber {
    
    private static final PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();
    String value;

    public PhoneNumber(String value) {
        this.value = value;
        validatePhoneNumber(value);
    }

    private static String validatePhoneNumber(String value) {

        try {
            if (Long.parseLong(value) <= 0) {
                throw new PhoneNumberParsingException("The phone number must be positive: " + value);
            }
            String formattedPhoneNumber = PHONE_NUMBER_UTIL.format(PHONE_NUMBER_UTIL.parse(value, "US"), PhoneNumberFormat.E164);
            return formattedPhoneNumber.substring(1);
        } catch (NumberParseException | NumberFormatException e) {
                throw new PhoneNumberParsingException("The phone number is not valid: " + value, e);
        }
    }

    
}
