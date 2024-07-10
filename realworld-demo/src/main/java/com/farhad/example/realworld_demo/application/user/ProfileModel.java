package com.farhad.example.realworld_demo.application.user;

import com.farhad.example.realworld_demo.domain.user.Profile;

import lombok.Value;

@Value
public class ProfileModel {

    private String username;
    private String bio;
    private String image;

    public static ProfileModel fromProfile(Profile profile) {
        return new ProfileModel(
            profile.getUserName().toString(),
            profile.getBio(),
            profile.getImage().toString());
    }
}
