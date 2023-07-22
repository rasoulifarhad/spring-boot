package com.farhad.example.valueobjectsdemo.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
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
@Table(name = "user_groups")
@Getter
public class UserGroup {
    
    @EmbeddedId
    private UserGroup.ID id;

    // @Id
    // private UUID id;

    private String name;

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
