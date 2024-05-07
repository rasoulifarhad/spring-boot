package com.farhad.example.dddhibernatedemo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue
    Long id;

    String email;
    String password;

    @OneToOne
    @JoinColumn(name = "home_address_id")
    Address homeAddress;

}
