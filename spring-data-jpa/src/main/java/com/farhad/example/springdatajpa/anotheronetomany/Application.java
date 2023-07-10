package com.farhad.example.springdatajpa.anotheronetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, 
                new String [] {
                    "--spring.h2.console.enabled=true",
                    "--spring.datasource.url=jdbc:h2:mem:test2",
                    "--spring.datasource.username=sa",
                    "--spring.datasource.password=sa"
                    // "--spring.jpa.open-in-view=false"
        }  );
    }

}
