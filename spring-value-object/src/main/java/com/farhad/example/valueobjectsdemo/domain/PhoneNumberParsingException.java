package com.farhad.example.valueobjectsdemo.domain;

public class PhoneNumberParsingException extends RuntimeException {

    public PhoneNumberParsingException(String string) {
        super(string);
    }

    public PhoneNumberParsingException(String string, Exception e) {
        super(string, e);
    }

}
