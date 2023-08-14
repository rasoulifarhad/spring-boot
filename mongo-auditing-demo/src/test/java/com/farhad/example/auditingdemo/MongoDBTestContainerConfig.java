package com.farhad.example.auditingdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;

public class MongoDBTestContainerConfig {
	
	public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0.2").withExposedPorts(27017);

	@BeforeAll
	public static void beforeAll() {
		mongoDBContainer.start();
	}

	@AfterAll
	public static void afterAll() {
		mongoDBContainer.stop();
	}


	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.port", mongoDBContainer::getFirstMappedPort);
		registry.add("mongodb.container.port", mongoDBContainer::getFirstMappedPort);

	}

}
