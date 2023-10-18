package com.farhad.example.shopping.infra.api.rest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private static final ApiInfo API_INFO = new ApiInfo(
		"Shopping List", 
		"Shopping  list with Onion architecture", 
		"1.0", 
		null, 
		null, 
		null, 
		null, 
		Collections.emptyList());

 	private static final Set<String> PRODUCES_AND_CONSUMES = new HashSet<>(
        							Arrays.asList("application/json", "application/xml"));
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
						.apiInfo(API_INFO)
						.produces(PRODUCES_AND_CONSUMES)
						.consumes(PRODUCES_AND_CONSUMES);
	}
}
