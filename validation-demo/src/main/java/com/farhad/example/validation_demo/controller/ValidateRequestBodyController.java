package com.farhad.example.validation_demo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.validation_demo.Input;

@RestController
public class ValidateRequestBodyController {
    
    @PostMapping("/validateBody")
    public ResponseEntity<String>  validateBody(@Valid @RequestBody Input input) {
        return ResponseEntity.ok("vALID");
    }
}
