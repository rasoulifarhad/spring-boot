package com.farhad.example.wiremockdemo.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.node.ArrayNode;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
	
	private final WebClient todoWebClient;

	@GetMapping
	public ArrayNode getAllTodos() {
		 Mono<ArrayNode> mono =  todoWebClient
									.get()
									.uri("/todos")
									.retrieve()
									.bodyToMono(ArrayNode.class);
		return mono.block();			
	}
}
