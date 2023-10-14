package com.farhad.example.coffeeorder.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.farhad.example.coffeeorder.architecture.UseCase;

@Configuration
@ComponentScan(
	basePackages = "com.farhad.example.coffeeorder.application",
	includeFilters = @ComponentScan.Filter(
			type = FilterType.ANNOTATION, value = UseCase.class)
)
public class DomainConfig {
	
}
