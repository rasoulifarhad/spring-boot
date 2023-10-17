package com.farhad.example.articles.adapters.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atricles")
public class ArticleEndPoint {
	
	private final ArticleApiService apiService;

	@GetMapping("{articleId}")
	ArticleResponse get(@PathVariable("articleId") String articleId) {
		return apiService.get(articleId);
	}

	@PostMapping
	public ArticleIdResponse create(@RequestBody ArticleRequest articleRequest) {
		return apiService.create(articleRequest);
	}
}
