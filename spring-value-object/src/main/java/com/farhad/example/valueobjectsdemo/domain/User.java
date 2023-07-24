package com.farhad.example.valueobjectsdemo.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.farhad.example.valueobjectsdemo.domain.converter.PassportConverter;
import com.farhad.example.valueobjectsdemo.domain.converter.PhoneNumberConverter;
import com.farhad.example.valueobjectsdemo.domain.converter.UserNameConverter;
import com.farhad.example.valueobjectsdemo.domain.value.Passport;
import com.farhad.example.valueobjectsdemo.domain.value.PhoneNumber;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@Entity
@Table(name = "users")
@Getter
@ToString
public class User {

    @EmbeddedId
    private User.ID id;
    // @Id
    // private UUID id;

    @Column(name = "name")
    @NotNull
    @Convert(converter = UserNameConverter.class)
    private Name name;

    @Column(name = "phone_number")
    @NotNull
    @Convert(converter = PhoneNumberConverter.class)
    private  PhoneNumber phoneNumber;

    @Convert(converter = PassportConverter.class)
    @NotNull
    private Passport passport;

    @Data
    @Setter( AccessLevel.PRIVATE)
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ID implements Serializable {

        @Column(updatable = false)
        @NotNull
        private UUID id;
    }

    public static User newUser(Name name, PhoneNumber phoneNumber, Passport passport) {
        User user = new User();
        user.id = new ID(UUID.randomUUID());
        user.name = name;
        user.phoneNumber = phoneNumber;
        user.passport = passport;
        return user;
    }

    @Value
    public static class Name {
        private String value;
    }
}
