package com.farhad.example.realworld_demo.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Profile {

    @Embedded
    private UserName userName;

    @Column(name = "bio")
    private String bio;
    
    @Embedded
    private Image image;
}
