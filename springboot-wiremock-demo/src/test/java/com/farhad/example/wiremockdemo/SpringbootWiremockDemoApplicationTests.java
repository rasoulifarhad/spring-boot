package com.farhad.example.wiremockdemo;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class SpringbootWiremockDemoApplicationTests {

	private static WireMockServer wireMockServer;

	@Autowired
	private MockMvc mockMvc;

	@BeforeAll
	static void init() {
		wireMockServer = new WireMockServer(
			new WireMockConfiguration().port(7075)
		);
		wireMockServer.start();
		WireMock.configureFor("localhost", 7075);
	}

	@Test
	void testCallHttpBinAnything() throws Exception {

		Given: 
		stubFor(WireMock.get(urlMatching("/anything"))
			.willReturn(aResponse().withStatus(OK.value())));
		
		When: 
		mockMvc.perform(get("/demo"))
			.andExpect(status().isOk());

		Then:
		verify(getRequestedFor(urlPathEqualTo("/anything")));	

	}

}
