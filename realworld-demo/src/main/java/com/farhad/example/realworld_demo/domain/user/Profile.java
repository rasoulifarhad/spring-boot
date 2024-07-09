package com.farhad.example.realworld_demo.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Profile {

    @Embedded

    private UserName userName;

    @Column(name = "bio")

    private String bio;

    @Embedded
    private Image image;

    public Profile(UserName userName) {
        this(userName, null, null);
    }

    

}
