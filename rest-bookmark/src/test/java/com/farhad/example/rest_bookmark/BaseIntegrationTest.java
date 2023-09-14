package com.farhad.example.rest_bookmark;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// @TestPropertySource(properties = {
//   "spring.test.database.replace=none",
//   "spring.datasource.url=jdbc:tc:postgresql:15.2-alpine:///db"
// })
// @TestPropertySource(properties = {
//   "spring.test.database.replace=none",
//   "spring.datasource.url=jdbc:tc:postgresql:13.2:///db"
// })
class BaseIntegrationTest {

	@LocalServerPort
	protected Integer serverPort;

	@Autowired
	TestRestTemplate restTemplate;

	// static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15.2-alpine");
	static PostgreSQLContainer<?> postgresContainer = 
		new PostgreSQLContainer<>("postgres:13.2")
				.withDatabaseName("shoestore")
				.withUsername("farhad")
				.withPassword("farhad");

	@BeforeAll
	static void setUp() {
		if (!postgresContainer.isRunning()) {
			postgresContainer.start();
		}
	}

	@AfterAll
	static void teardown() {

	}
	
	@DynamicPropertySource
	static void registerDynamicProperties(DynamicPropertyRegistry  registry ) {
		registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
		registry.add("spring.datasource.username", postgresContainer::getUsername);
		registry.add("spring.datasource.password", postgresContainer::getPassword);
	}

}
