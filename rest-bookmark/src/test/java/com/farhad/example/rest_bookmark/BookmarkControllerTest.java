package com.farhad.example.rest_bookmark;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookmarkControllerTest /*extends BaseIntegrationTest*/ {

	@LocalServerPort
	protected Integer serverPort;

	static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:13.2");

	@BeforeAll
	static void setUp() {
		if (!postgresContainer.isRunning()) {
			postgresContainer.start();
		}
	}


	@AfterAll
	static void teardown() {
		postgresContainer.stop();
	}

	@BeforeEach
	void beforeEach() {
		RestAssured.baseURI = "http://localhost:" + serverPort;
		RestAssured.port = serverPort;
	}
	
	@DynamicPropertySource
	static void registerDynamicProperties(DynamicPropertyRegistry  registry ) {
		registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
		registry.add("spring.datasource.username", postgresContainer::getUsername);
		registry.add("spring.datasource.password", postgresContainer::getPassword);
	}

	@Test
	@Sql("/test_data.sql")
	public void shouldGetBookmarksByPage() {
		given().contentType(ContentType.JSON)
				.when()
				.get("/api/bookmarks?page=1&size=10")
				.then()
				.statusCode(200)
				.body("data.size()", equalTo(10))
				.body("totalElements", equalTo(15))
				.body("pageNumber", equalTo(1))
				.body("totalPages", equalTo(2))
				.body("isFirst", equalTo(true))
				.body("isLast", equalTo(false))
				.body("hasNext", equalTo(true))
				.body("hasPrevious", equalTo(false));
	}
}
