package com.farhad.example.templatebasedemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TemplateBasedEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateBasedEmailApplication.class, args);
	}

}
