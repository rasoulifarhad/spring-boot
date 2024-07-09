package com.farhad.example.realworld_demo.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Email {

    @Column(name = "email", nullable = false)
    private String address;

    @Override
    public String toString() {
        return address;
    }

    
}
