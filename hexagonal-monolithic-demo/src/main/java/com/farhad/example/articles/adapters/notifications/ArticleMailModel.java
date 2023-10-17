package com.farhad.example.articles.adapters.notifications;

import com.farhad.example.articles.domain.model.Article;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString(of = "subject")
@Getter
@EqualsAndHashCode
@Builder(setterPrefix = "with")
public class ArticleMailModel {
	
    private static final String SUBJECT = "You have successfully published: >>%s<<";
    private static final String CONTENT = "Check if everything is correct: >>%s<<";

    private final String recipientId;
    private final String subject;
    private final String content;

	public static ArticleMailModel of(Article article) {
		return ArticleMailModel.builder()
					.withRecipientId(article.getAuthor().getName())
					.withContent(String.format(CONTENT,article.getContent().getValue()))
					.withSubject(String.format(SUBJECT,article.getTitle().getValue()))
					.build();
	}

}
