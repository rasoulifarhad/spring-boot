package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.ddd_hexagonal_spring_data.application.service.UserService;
import com.farhad.example.ddd_hexagonal_spring_data.domain.model.user.UserRepository;

@Configuration
public class SpringBootServiceConfig {
    
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
