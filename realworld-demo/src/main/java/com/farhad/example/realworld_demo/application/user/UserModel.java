package com.farhad.example.realworld_demo.application.user;

import static java.lang.String.valueOf;

import com.farhad.example.realworld_demo.domain.user.User;

import lombok.Value;

@Value
public class UserModel {

    String email;
    String username;
    String bio;
    String umage;

    static UserModel fromUser(User user) {
        return new UserModel(
            valueOf(user.getEmail()), 
            valueOf(user.getName()), 
            "", 
            "");
    }

}
