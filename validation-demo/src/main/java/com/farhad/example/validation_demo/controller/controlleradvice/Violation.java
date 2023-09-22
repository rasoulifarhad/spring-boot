package com.farhad.example.validation_demo.controller.controlleradvice;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Violation {

    private final String fieldName;
    private final String message;
}
