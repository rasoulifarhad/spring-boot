package com.farhad.example.valueobjectsdemo.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.farhad.example.valueobjectsdemo.domain.converter.PassportConverter;
import com.farhad.example.valueobjectsdemo.domain.converter.PhoneNumberConverter;
import com.farhad.example.valueobjectsdemo.domain.value.Passport;
import com.farhad.example.valueobjectsdemo.domain.value.PhoneNumber;

import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@ToString
public class User {

    // @EmbeddedId
    // private User.ID id;
    @Id
    private UUID id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "phone_number")
    @NotNull
    @Convert(converter = PhoneNumberConverter.class)
    private  PhoneNumber phoneNumber;

    @Convert(converter = PassportConverter.class)
    @NotNull
    private Passport passport;
    // @Data
    // @Setter(value = AccessLevel.PRIVATE)
    // @Embeddable
    // @AllArgsConstructor
    // @NoArgsConstructor(access = AccessLevel.PROTECTED)
    // public static class ID implements Serializable {

    //     @Column(updatable = false)
    //     @NotNull
    //     private UUID id;
    // }

    public static User newUser(String name, PhoneNumber phoneNumber, Passport passport) {
        User user = new User();
        user.id = UUID.randomUUID();
        user.name = name;
        user.phoneNumber = phoneNumber;
        user.passport = passport;
        return user;
    }
}
