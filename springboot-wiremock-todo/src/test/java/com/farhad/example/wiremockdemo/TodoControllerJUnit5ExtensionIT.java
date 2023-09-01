package com.farhad.example.wiremockdemo;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.google.common.net.HttpHeaders;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodoControllerJUnit5ExtensionIT {
	
	@LocalServerPort
	int port;

	@RegisterExtension
	static WireMockExtension wireMockServer = 
				WireMockExtension.newInstance()
								.options(WireMockConfiguration.wireMockConfig().dynamicPort())
								.build();
 
	

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("todo_base_url", wireMockServer::baseUrl);
	}

	@AfterEach
	public void afterEach() {
		wireMockServer.resetAll();
	}


	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testGetAllTodosShouldReturnDataFromClient() {

		Given: 
		wireMockServer.stubFor(
			WireMock.get("/todos")
				.willReturn(aResponse()
					.withHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
					// .withBodyFile("todo-api/response-200.json")
					.withBody("[{\"userId\": 1,\"id\": 1,\"title\": \"Learn Spring Boot 3.0\", \"completed\": false}," +
					"{\"userId\": 1,\"id\": 2,\"title\": \"Learn WireMock\", \"completed\": true}]")));

		When:
		webTestClient
			.get()
			.uri("/api/todos")
			.exchange()
			.expectStatus().is2xxSuccessful()
			.expectBody()
			.jsonPath("$[0].title").isEqualTo("Learn Spring Boot 3.0")
			.jsonPath("$.length()").isEqualTo(2);

	}

	@Test
	public void testGetAllTodosShouldPropagateErrorMessageFromClient() {

		Given: 
		wireMockServer.stubFor(
			WireMock.get("/todos")
				.willReturn(aResponse()
					.withStatus(403)));

		When: 
		webTestClient
			.get()
			.uri("http://localhost:" + port + "/api/todos")
			.exchange()
			.expectStatus().isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Test
	public void testGetAllTodosShouldPropagateErrorMessageFromClientWithDelay() {

		Given: 
		wireMockServer.stubFor(
			WireMock.get("/todos")
				.willReturn(aResponse()
					.withStatus(403)
					.withFixedDelay(2000)));

		When: 
		webTestClient
			.get()
			.uri("http://localhost:" + port + "/api/todos")
			.exchange()
			.expectStatus().isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
