package com.farhad.example.springdatajpa.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, 
                new String [] {
                    "--spring.h2.console.enabled=true",
                    "--spring.datasource.url=jdbc:h2:mem:test",
                    "--spring.datasource.driverClassName=org.h2.Driver",
                    "--spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
                    "--spring.datasource.username=sa",
                    "--spring.datasource.password=sa"
        }  );
    }
}
