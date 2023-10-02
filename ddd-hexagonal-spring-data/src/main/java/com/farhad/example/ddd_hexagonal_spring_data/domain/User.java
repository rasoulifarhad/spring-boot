package com.farhad.example.ddd_hexagonal_spring_data.domain;

import lombok.Data;

@Data
public class User {
    
    private Long id;
    private String name;
    private String address;

}
