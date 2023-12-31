package com.farhad.example.wiremockdemo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.wiremockdemo.demo.httpbin.HttpBinProxy;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DemoController {
	
	private final HttpBinProxy httpBinProxy;

	@GetMapping("/demo")
	public String getAnything() {
		return httpBinProxy.getAnything();
	}
}
