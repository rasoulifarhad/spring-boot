package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@DataJpaTest
@ComponentScan("com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance")
public @interface PersistenceTest {
	
}
