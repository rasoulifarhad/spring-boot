package com.farhad.example.storedemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import com.farhad.example.storedemo.store_app.http.api.shoes.ShoeData;
import com.farhad.example.storedemo.store_app.http.api.shoes.ShoeResults;

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
	static GenericContainer<?> redisContainer = 
		new GenericContainer<>(DockerImageName.parse("redis:7.0.5-alpine")).withExposedPorts(6379);

	@BeforeAll
	static void setUp() {
		if (!postgresContainer.isRunning()) {
			postgresContainer.start();
		}
		if(!redisContainer.isRunning()) {
			redisContainer.start();
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
		log.info("Configuring Redis: {}, {}",redisContainer.getHost(), redisContainer.getMappedPort(6379).toString());
		registry.add("spring.redis.host", redisContainer::getHost);
		registry.add("spring.redis.port", () -> redisContainer.getMappedPort(6379).toString() );
	}

	protected ShoeData shoeByName(String namePart) {
		ShoeResults shoeResults = restTemplate.getForObject(
									String.format("http://localhost:%d/shoes?name=%s",serverPort, namePart).toString(), 
									ShoeResults.class);
		return shoeResults.getShoes().get(0);
		
	}
}
