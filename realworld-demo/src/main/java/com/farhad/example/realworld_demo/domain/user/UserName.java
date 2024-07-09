package com.farhad.example.realworld_demo.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserName {

    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public String toString() {
        return name;
    }

    
}
