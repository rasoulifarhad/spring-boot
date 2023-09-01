package com.farhad.example.wiremockdemo;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class ManualSetupIT {
	
	@Autowired
	private WebTestClient webTestClient;

	private static WireMockServer wireMockServer;

	@DynamicPropertySource
	static void overrideWebClientBaseUrl(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("todo_base_url", wireMockServer::baseUrl);
	}

	@BeforeAll
	static void startWirMockServer() {
		wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
		wireMockServer.start();
	}

	@AfterAll
	static void stopWireMockServer() {
		wireMockServer.stop();
	}

	@BeforeEach
	void clearWireMockServer() {
		wireMockServer.resetAll();
	}

	@Test
	public void testWirMockServer() {
		System.out.println(wireMockServer.baseUrl());
		assertTrue(wireMockServer.isRunning());
	}

	@Test
	@Order(1)
	public void basicWireMockExample() {
		wireMockServer.stubFor(
			WireMock.get("/todos")
				.willReturn(aResponse()
					.withHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
					.withBody("[]")));

		webTestClient
			.get()
			.uri("/api/todos")
			.exchange()
			.expectStatus().isOk()
			.expectBody().jsonPath("$.length()").isEqualTo(0);
	}
	
	@Test
	@Order(2)
	public void basicWireMockExample2() {

		wireMockServer.stubFor(
			WireMock.get(WireMock.urlEqualTo("/users"))
				.willReturn(aResponse()
					.withHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
					.withBody("[]")));

		webTestClient
			.get()
			.uri("/api/todos")
			.exchange()
			.expectStatus().is5xxServerError();
	}

	@Test
	public void basicWireMockExampleWithPriority() {
		wireMockServer.stubFor(
			WireMock.get(WireMock.urlEqualTo("/todos"))
				.atPriority(1)
				.willReturn(aResponse()
					.withHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
					.withBodyFile("todo-api/response-200.json")
					.withFixedDelay(1_000)));

		wireMockServer.stubFor(
			WireMock.get(WireMock.urlEqualTo("/todos"))
				.atPriority(10)
				.willReturn(aResponse()
					.withStatus(500)));

		webTestClient
			.get()
			.uri("/api/todos")
			.exchange()
			.expectStatus().isOk()
			.expectBody().jsonPath("$.length()").isEqualTo(3);
	}

	@Test
	public void basicWireMockExampleWithData() {
		wireMockServer.stubFor(
			WireMock.get(WireMock.urlEqualTo("/todos"))
				.willReturn(aResponse()
					.withHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
					.withBodyFile("todo-api/response-200.json")
					.withFixedDelay(1_000)));


		webTestClient
			.get()
			.uri("/api/todos")
			.exchange()
			.expectStatus().isOk()
			.expectBody().jsonPath("$.length()").isEqualTo(3);
	}

	@Test
	public void testExactUrlOnly() {
		wireMockServer.stubFor(WireMock.get(urlEqualTo("/todos"))
					.willReturn(aResponse()
						.withHeader("Content-Type",MediaType.APPLICATION_JSON_VALUE)
						.withBody("[]")));

		webTestClient.get().uri("/api/todos")
			.exchange()
			.expectStatus().isOk();
		
		webTestClient.get().uri("/api/todos/some/thing/else")
			.exchange()
			.expectStatus().is4xxClientError();
	}

	@Test
	public void testPerStubRandomDelays() {
		wireMockServer.stubFor(WireMock.get(urlEqualTo("/todos"))
					.willReturn(aResponse()
						.withHeader("Content-Type",MediaType.APPLICATION_JSON_VALUE)
						.withLogNormalRandomDelay(90,0.1)
						.withBody("[]")));

		webTestClient.get().uri("/api/todos")
			.exchange()
			.expectStatus().isOk();
		
	}

}
