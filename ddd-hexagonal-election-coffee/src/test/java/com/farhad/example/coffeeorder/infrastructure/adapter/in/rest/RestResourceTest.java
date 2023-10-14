package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

import com.farhad.example.coffeeorder.infrastructure.config.DomainConfigTest;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@WebMvcTest
@Import(DomainConfigTest.class)
public @interface RestResourceTest {
	
}
