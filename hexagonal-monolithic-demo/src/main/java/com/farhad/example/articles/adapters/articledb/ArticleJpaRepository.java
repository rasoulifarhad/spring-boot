package com.farhad.example.articles.adapters.articledb;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaRepository extends JpaRepository<ArticleDatabaseModel, UUID>  {
	
}
