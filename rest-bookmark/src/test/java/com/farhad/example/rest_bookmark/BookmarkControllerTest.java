package com.farhad.example.rest_bookmark;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

import com.farhad.example.rest_bookmark.bookmarks.domain.Bookmark;
import com.farhad.example.rest_bookmark.bookmarks.domain.BookmarkRepository;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookmarkControllerTest /*extends BaseIntegrationTest*/ {

	@Autowired
	private BookmarkRepository bookmarkRepository;

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
		bookmarkRepository.deleteAll();
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
		List<Bookmark> bookmarks = new ArrayList<>(
			Arrays.asList(	
				new Bookmark("How (not) to ask for Technical Help?","https://sivalabs.in/how-to-not-to-ask-for-technical-help", Instant.now()),
				new Bookmark("Announcing My SpringBoot Tips Video Series on YouTube","https://sivalabs.in/announcing-my-springboot-tips-video-series", Instant.now()),
				new Bookmark("Kubernetes - Exposing Services to outside of Cluster using Ingress","https://sivalabs.in/kubernetes-ingress", Instant.now()),
				new Bookmark("Kubernetes - Blue/Green Deployments","https://sivalabs.in/kubernetes-blue-green-deployments", Instant.now()),
				new Bookmark("Kubernetes - Releasing a new version of the application using Deployment Rolling Updates","https://sivalabs.in/kubernetes-deployment-rolling-updates", Instant.now()),
				new Bookmark("Getting Started with Kubernetes","https://sivalabs.in/getting-started-with-kubernetes", Instant.now()),
				new Bookmark("Get Super Productive with Intellij File Templates","https://sivalabs.in/get-super-productive-with-intellij-file-templates", Instant.now()),
				new Bookmark("Few Things I learned in the HardWay in 15 years of my career","https://sivalabs.in/few-things-i-learned-the-hardway-in-15-years-of-my-career", Instant.now()),
				new Bookmark("All the resources you ever need as a Java & Spring application developer","https://sivalabs.in/all-the-resources-you-ever-need-as-a-java-spring-application-developer", Instant.now()),
				new Bookmark("GoLang from a Java developer perspective","https://sivalabs.in/golang-from-a-java-developer-perspective", Instant.now()),
				new Bookmark("Imposing Code Structure Guidelines using ArchUnit","https://sivalabs.in/impose-architecture-guidelines-using-archunit", Instant.now()),
				new Bookmark("SpringBoot Integration Testing using TestContainers Starter","https://sivalabs.in/spring-boot-integration-testing-using-testcontainers-starter", Instant.now()),
				new Bookmark("Creating Yeoman based SpringBoot Generator","https://sivalabs.in/creating-yeoman-based-springboot-generator", Instant.now()),
				new Bookmark("Testing REST APIs using Postman and Newman","https://sivalabs.in/testing-rest-apis-with-postman-newman", Instant.now()),
				new Bookmark("Testing SpringBoot Applications","https://sivalabs.in/spring-boot-testing", Instant.now())
				
			)
		); 
		bookmarkRepository.saveAll(bookmarks);
		
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
