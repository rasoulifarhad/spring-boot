package com.farhad.example.auditingdemo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerWithoutVersionRepository  extends MongoRepository<CustomerWoV, String> {
    
    public List<CustomerWoV> findByName(String name);

}
