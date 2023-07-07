package com.farhad.example.springdatajpa.manytomany.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.springdatajpa.manytomany.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StudentController {
    
    private final StudentRepository repository;

    @GetMapping("/students")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok().body(repository.findAll());
    }
}
