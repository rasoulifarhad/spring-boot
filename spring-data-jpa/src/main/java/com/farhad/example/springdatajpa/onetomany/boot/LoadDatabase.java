package com.farhad.example.springdatajpa.onetomany.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.springdatajpa.onetomany.repository.LibraryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LoadDatabase {
    
    // Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
    @Bean
    public CommandLineRunner initDatabase(LibraryRepository repository) {
        return args -> {
            log.info("");
        };
    }
}
