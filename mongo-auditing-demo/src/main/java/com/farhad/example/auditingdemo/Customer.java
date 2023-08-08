package com.farhad.example.auditingdemo;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;


    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

}

