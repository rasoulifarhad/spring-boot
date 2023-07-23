package com.farhad.example.valueobjectsdemo.boot;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.repository.UserRepository;
import com.farhad.example.valueobjectsdemo.domain.value.Passport;
import com.farhad.example.valueobjectsdemo.domain.value.PhoneNumber;

@Configuration
public class Config {
    
    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            userRepository.deleteAll();
            User user = User.newUser("user1", new PhoneNumber("78005553535"), Passport.parse("8410123456"));
            User savedUser = userRepository.save(user);
            System.out.println("Saved: " + savedUser);

            Optional<User> loadedUser = userRepository.findById(savedUser.getId());
            System.out.println("loaded: " + loadedUser);

            System.out.println("Finded: " + userRepository.findByPhoneNumber(new PhoneNumber("78005553535")));

        };
    }

    
}
