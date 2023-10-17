package com.farhad.example.articles.adapters.notifications;

import com.farhad.example.articles.domain.model.Article;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString(of = "text")
@Getter
@EqualsAndHashCode
@Builder(setterPrefix = "with")
public class ArticleSmsModel {
    
	public static final String CONTENT = "Please check your email. We have sent you publication details of the article: >>%s<<";
	
    private final String recipientId;
    private final String text;

	public static ArticleSmsModel of(Article article) {
		return ArticleSmsModel.builder()
					.withRecipientId(article.getAuthor().getName())
					.withText(String.format(CONTENT,article.getTitle().getValue()))
					.build();
	}

}
