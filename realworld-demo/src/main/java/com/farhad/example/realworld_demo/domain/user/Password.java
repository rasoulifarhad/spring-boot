package com.farhad.example.realworld_demo.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

    @Column(name = "password", nullable = false)
    private String encodedPassword;

    static Password of(String rawPasswotd, PasswordEncoder passwordEncoder) {
        return new Password(passwordEncoder.encode(rawPasswotd));
    }

    boolean matchesPasword(String rawPassword, PasswordEncoder passwordEncoder)  {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
