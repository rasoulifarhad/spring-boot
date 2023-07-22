package com.farhad.example.valueobjectsdemo.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
public class User {

    @EmbeddedId
    private User.ID id;
    // @Id
    // private UUID id;

    @Column(name = "phone_number")
    @NotNull
    @Convert(converter = PhoneNumberConverter.class)
    private  String phoneNumber;

    @Data
    @Setter(value = AccessLevel.PRIVATE)
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ID implements Serializable {

        @Column(updatable = false)
        @NotNull
        private UUID id;
    }
}
