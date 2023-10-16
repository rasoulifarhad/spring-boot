package com.farhad.example.dddmonolithic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DddMonolithicDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddMonolithicDemoApplication.class, args);
	}

}
