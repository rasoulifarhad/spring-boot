package com.farhad.example.wiremockdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.farhad.example.wiremockdemo.httpbin")
public class SpringbootWiremockDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWiremockDemoApplication.class, args);
	}

}
