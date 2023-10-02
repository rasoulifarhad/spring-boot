package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.farhad.example.ddd_hexagonal_spring_data")
@EntityScan(basePackages = "com.farhad.example.ddd_hexagonal_spring_data")
public class SpringBootService {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootService.class, args);
    }
}
