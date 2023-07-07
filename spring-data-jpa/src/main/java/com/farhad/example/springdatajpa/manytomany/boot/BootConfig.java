package com.farhad.example.springdatajpa.manytomany.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.springdatajpa.manytomany.model.Role;
import com.farhad.example.springdatajpa.manytomany.model.Users;
import com.farhad.example.springdatajpa.manytomany.repository.CourseRepository;
import com.farhad.example.springdatajpa.manytomany.repository.RoleRepository;
import com.farhad.example.springdatajpa.manytomany.repository.StudentRepository;
import com.farhad.example.springdatajpa.manytomany.repository.UsersRepository;

@Configuration
public class BootConfig {
    
    @Bean
    public CommandLineRunner init(UsersRepository usersRepository,
                                 RoleRepository roleRepository,
                                 StudentRepository studentRepository,
                                 CourseRepository courseRepository) {
        return args -> {
            usersRepository.save(getUsers1());
            usersRepository.save(getUsers2());
        };
    }

    private Users getUsers1() {
            Users user = new Users();
            user.setUsername("user1");
            user.setPassword("user1-password");
            user.setEmail("user1@example.com");

            Role role = new Role();
            role.setName("Role no 01");
            user.getRoles().add(role);
            
            return user;
    }

    private Users getUsers2() {
            Users user = new Users();
            user.setUsername("user2");
            user.setPassword("user2-password");
            user.setEmail("user2@example.com");

            Role role2 = new Role();
            role2.setName("Role no 02");

            Role role3 = new Role();
            role3.setName("Role no 03");

            user.getRoles().add(role2);
            user.getRoles().add(role3);
            
            return user;
    }

}
