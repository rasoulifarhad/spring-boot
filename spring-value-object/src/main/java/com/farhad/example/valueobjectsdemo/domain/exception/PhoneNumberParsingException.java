package com.farhad.example.valueobjectsdemo.domain.exception;

public class PhoneNumberParsingException extends RuntimeException {

    public PhoneNumberParsingException(String string) {
        super(string);
    }

    public PhoneNumberParsingException(String string, Exception e) {
        super(string, e);
    }

}
