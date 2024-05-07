package com.farhad.example.dddhibernatedemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Admin {

    @Id
    @GeneratedValue
    Long id;

    String email;
    String password;
}
