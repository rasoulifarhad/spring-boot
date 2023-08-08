package com.farhad.example.auditingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class MongoAuditingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoAuditingDemoApplication.class, args);
	}

}
