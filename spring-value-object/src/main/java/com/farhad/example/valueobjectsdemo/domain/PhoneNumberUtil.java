package com.farhad.example.valueobjectsdemo.domain;

public class PhoneNumberUtil {

    private static final PhoneNumberUtil  INSTANCE = new PhoneNumberUtil();
    private PhoneNumberUtil() {

    }
    public static PhoneNumberUtil getInstance() {
        return INSTANCE;
    }

}
