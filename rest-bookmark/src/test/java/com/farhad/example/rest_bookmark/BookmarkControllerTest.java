package com.farhad.example.rest_bookmark;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;

import com.farhad.example.rest_bookmark.bookmarks.domain.BookmarkDTO;
import com.farhad.example.rest_bookmark.bookmarks.domain.BookmarkService;
import com.farhad.example.rest_bookmark.bookmarks.domain.CreateBookmarkCommand;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookmarkControllerTest /*extends BaseIntegrationTest*/ {

	@Autowired
	private BookmarkService bookmarkService;

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

	@Test
	public void shouldCreateBookmarkSuccessfully() {
		given().contentType(ContentType.JSON)
			   .body(
				"{\"title\": \"googleee\", \"url\": \"https://google.com\"}"
			   )
			   .when()
			   .post("/api/bookmarks")	
			   .then()
			   .statusCode(201)
			   .header("Location", matchesRegex(".*/api/bookmarks/[0-9]+$"))
			   .body("id", notNullValue())
			   .body("title", equalTo("googleee"))
			   .body("url", equalTo("https://google.com"))
			   .body("createdAt", notNullValue())
			   .body("updatedAt", nullValue()); 

	}

	@Test
	public void shouldUpdateBookmarkSuccessfully() {
		CreateBookmarkCommand cmd = new CreateBookmarkCommand("googleee", "https://google.com");
		BookmarkDTO bookmark = bookmarkService.create(cmd);
		given().contentType(ContentType.JSON)
			   .body(
				"{\"title\": \"googleee-updated\", \"url\": \"https://google.com\"}"
			   )
			   .when()
			   .put("/api/bookmarks/{id}", bookmark.getId())	
			   .then()
			   .statusCode(200);
	}

	@Test
	void shouldGetBookmarkByIdSuccessfully() {

		CreateBookmarkCommand cmd = new CreateBookmarkCommand("googleee", "https://google.com");
		BookmarkDTO bookmark = bookmarkService.create(cmd);

		given().contentType(ContentType.JSON)
				.when()
				.get("/api/bookmarks/{id}",bookmark.getId())
				.then()
				.statusCode(200)
				.body("id", equalTo(bookmark.getId()))
			    .body("title", equalTo("googleee"))
			    .body("url", equalTo("https://google.com"))
				.body("createdAt", notNullValue())
				.body("updatedAt", nullValue());
	}

	@Test
	void shouldGet404WhenBookmarkNotExists() {
		Long nonExistingId = 99999L;
		given().contentType(ContentType.JSON)
				.when()
				.get("/api/bookmarks/{id}", nonExistingId)
				.then()
				.statusCode(404);
	}

	@Test
	void shouldDeleteBookmarkByIdSuccessfully() {
		CreateBookmarkCommand cmd = new CreateBookmarkCommand("googleee", "https://google.com");
		BookmarkDTO bookmark = bookmarkService.create(cmd);

		given().contentType(ContentType.JSON)
				.when()
				.delete("/api/bookmarks/{id}",bookmark.getId())
				.then()
				.statusCode(200);

		Optional<BookmarkDTO> optionalBookmark = bookmarkService.findById(bookmark.getId());
		assertFalse(optionalBookmark.isPresent());
	}

}
