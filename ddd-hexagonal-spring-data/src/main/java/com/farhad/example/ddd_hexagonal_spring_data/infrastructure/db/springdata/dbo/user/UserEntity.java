package com.farhad.example.ddd_hexagonal_spring_data.infrastructure.db.springdata.dbo.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    
    @Id
    private Long id;

    private String name;

    private String address;
}
