package com.farhad.example.articles.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.articles.domain.ArticlePublisher;
import com.farhad.example.articles.domain.ports.ArticleMessageSender;
import com.farhad.example.articles.domain.ports.ArticleRepository;
import com.farhad.example.articles.domain.ports.ArticleService;
import com.farhad.example.articles.domain.ports.AuthorNotifier;
import com.farhad.example.articles.domain.ports.AuthorRepository;
import com.farhad.example.articles.domain.ports.SocialMediaPublisher;

@Configuration
public class ArticleConfig {
	
	@Bean
	ArticlePublisher articleEventPublisher(
				final ArticleMessageSender articleMessageSender,
				final List<SocialMediaPublisher> socialMediaPublishers,
				final List<AuthorNotifier> articleAuthorNotifiers) {

		return new ArticlePublisher(articleMessageSender, socialMediaPublishers, articleAuthorNotifiers);

	}

	@Bean
	ArticleService articleService(
				final ArticleRepository articleRepository,
				final AuthorRepository authorRepository,
				ArticlePublisher articlePublisher) {

		return new ArticleService(articleRepository, authorRepository, articlePublisher);
	}
}
