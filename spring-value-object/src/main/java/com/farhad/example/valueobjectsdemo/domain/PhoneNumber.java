package com.farhad.example.valueobjectsdemo.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class PhoneNumber {
    
    String value;
}
