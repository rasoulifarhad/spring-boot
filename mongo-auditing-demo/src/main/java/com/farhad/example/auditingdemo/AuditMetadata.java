package com.farhad.example.auditingdemo;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class AuditMetadata {

    @CreatedDate
    private Instant createdDateEmbeded;

    @LastModifiedDate
    private Instant lastModifiedDateEmbeded;
    
}
