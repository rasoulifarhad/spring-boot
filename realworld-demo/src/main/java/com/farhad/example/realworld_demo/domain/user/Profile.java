package com.farhad.example.realworld_demo.domain.user;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Profile {

    @Embedded
    private UserName userName;

    @Embedded
    private Image image;
}
