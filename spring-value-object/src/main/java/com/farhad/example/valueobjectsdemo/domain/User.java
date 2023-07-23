package com.farhad.example.valueobjectsdemo.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

    @Column(name = "phone_number")
    @NotNull
    @Convert(converter = PhoneNumberConverter.class)
    private  PhoneNumber phoneNumber;

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

    public static User newUser(PhoneNumber phoneNumber) {
        User user = new User();
        user.id = UUID.randomUUID();
        user.phoneNumber = phoneNumber;
        return user;
    }
}
