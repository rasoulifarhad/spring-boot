package com.farhad.example.springdatajpa.onetoone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.farhad.example.springdatajpa.onetoone.model.Address;
import com.farhad.example.springdatajpa.onetoone.model.User;
import com.farhad.example.springdatajpa.onetoone.repository.AddressRepository;
import com.farhad.example.springdatajpa.onetoone.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
// @RequiredArgsConstructor
public class UserRepositoryTest {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    User user;
    Address address;
    Long addressId;
    Long userId;

    @BeforeEach
    public void setUp() {
        user = User.builder()
                            .username("Farhad")
                            .build();
        address = Address.builder()
                                    .city("Tehran")
                                    .street("laleh")
                                    .country("Iran")
                                    .build();
        address.setUser(user);
        user.setAddress(address);
        Address savedAddress = addressRepository.save(address);
        User savedUser = userRepository.save(user);
        addressId = savedAddress.getId();
        userId = savedUser.getId();
    }

    @Test
    public void getUserWithAddressTest() {
        User user = userRepository.findById(userId).orElse(null);
        log.info("{}", user);
        log.info("{}", user.getAddress());
        assertNotNull(user);
        assertEquals("Tehran", user.getAddress().getCity());
    }

    @Test
    public void getUserButIsNull() {
        User user = userRepository.findById(100L).orElse(null);
        log.info("{}", user);
        assertNull(user);
    }

    @Test
    public void getAddressWithUserTest() {
        Address address = addressRepository.findById(addressId).orElse(null);
        log.info("{}", address);
        log.info("{}", address.getUser());
        assertNotNull(address.getUser());
        assertEquals("Farhad", address.getUser().getUsername());
    }

    @Test
    public void deleteCascadeTest() {
        userRepository.deleteById(userId);
        Address address = addressRepository.findById(addressId).orElse(null);
        assertNull(address);
    }
}
