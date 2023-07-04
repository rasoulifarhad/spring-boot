package com.farhad.example.springdatajpa.onetoone;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.farhad.example.springdatajpa.onetoone.model.Address;
import com.farhad.example.springdatajpa.onetoone.model.User;
import com.farhad.example.springdatajpa.onetoone.repository.AddressRepository;
import com.farhad.example.springdatajpa.onetoone.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataBootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
                            .username("Farhad")
                            .build();
        Address address = Address.builder()
                                    .city("Tehran")
                                    .street("laleh")
                                    .country("Iran")
                                    .build();
        address.setUser(user);
        user.setAddress(address);
        addressRepository.save(address);
        userRepository.save(user);
    }
    
}
