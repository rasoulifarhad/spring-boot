package com.farhad.example.petclinic.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.farhad.example.petclinic.architecture.UseCase;

@Configuration
@ComponentScan(
	basePackages = "com.farhad.example.coffeeorder.application",
	includeFilters = @ComponentScan.Filter(
			type = FilterType.ANNOTATION, value = UseCase.class)
)
public class DomainConfig {
	
}
