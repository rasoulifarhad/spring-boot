package com.farhad.example.valueobjectsdemo.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User {
    
    @Id
    private UUID id;

    @Column(name = "phone_number")
    private  String phoneNumber;
}
