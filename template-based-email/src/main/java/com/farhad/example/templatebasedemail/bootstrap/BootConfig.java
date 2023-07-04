package com.farhad.example.templatebasedemail.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.templatebasedemail.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class BootConfig {
    
    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
            log.info("");
        } ;
    }
}
