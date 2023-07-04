package com.farhad.example.springdatajpa.onetoone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String country;

    @OneToOne(mappedBy = "address")
    private User user;

    public String toString() {
        return String.format("Address {id=%d, country=%s, city=%s, street=%s}", id, country, city, street);
    }

}
