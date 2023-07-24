package com.farhad.example.valueobjectsdemo.boot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.User.Name;
import com.farhad.example.valueobjectsdemo.domain.repository.UserRepository;
import com.farhad.example.valueobjectsdemo.domain.value.Passport;
import com.farhad.example.valueobjectsdemo.domain.value.PhoneNumber;

@Configuration
public class Config {
    
    @Bean 
    public RestTemplate  restTemplate(RestTemplateBuilder builder) {
        return builder.build(); 
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, RestTemplate restTemplate) {
        return args -> {
            userRepository.deleteAll();
            User user = User.newUser(new Name("user1"), new PhoneNumber("78005553535"), Passport.parse("8410123456"));
            User savedUser = userRepository.save(user);
            System.out.println("Saved: " + savedUser);

            Optional<User> loadedUser = userRepository.findById(savedUser.getId());
            System.out.println("loaded: " + loadedUser);

            System.out.println("Finded: " + userRepository.findByPhoneNumber(new PhoneNumber("78005553535")));

            System.out.println("Passport: " + userRepository.findPassportById(loadedUser.get().getId()));

            Map<String,Object> map = new HashMap<>();
            map.put("phoneNumber", "71234567890");
            map.put("passport", "8410123455");
            map.put("name", "user2");
            
            restTemplate.postForEntity(
                "http://localhost:8080/api/users?phoneNumber={phoneNumber}&passport={passport}&name={name}", 
                null, 
                Void.class,map);

            final ResponseEntity<Map> response = 
                restTemplate.getForEntity(
                    "http://localhost:8080/api/users?phoneNumber={phoneNumber}", 
                    Map.class, 
                    Collections.singletonMap("phoneNumber", "71234567890"));

            System.out.println(response);
        };
    }

    
}
