package com.farhad.example.valueobjectsdemo.domain;

import java.util.UUID;

// @Entity
// @Table(name = "user_groups")
// @Getter
public class UserGroup {
    
    // @EmbeddedId
    // private UserGroup.ID id;

    // @Id
    private UUID id;

    private String name;

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
}
