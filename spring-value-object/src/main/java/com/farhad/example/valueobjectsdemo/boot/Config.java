package com.farhad.example.valueobjectsdemo.boot;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.valueobjectsdemo.domain.PhoneNumber;
import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.repository.UserRepository;

@Configuration
public class Config {
    
    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            User user = User.newUser(new PhoneNumber("78005553535"));
            User savedUser = userRepository.save(user);
            System.out.println(savedUser);

            Optional<User> loadedUser = userRepository.findById(savedUser.getId());
            System.out.println(loadedUser);

        };
    }

    
}
