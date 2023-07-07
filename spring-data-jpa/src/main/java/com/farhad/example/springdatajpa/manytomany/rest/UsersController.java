package com.farhad.example.springdatajpa.manytomany.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.springdatajpa.manytomany.model.Users;
import com.farhad.example.springdatajpa.manytomany.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UsersController {
    
    private final UsersRepository repository;

    @GetMapping("/users")
    public ResponseEntity<?> all() {
        List<Users> all = repository.findAll();
        if(all.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(all);
        }
    }
}
