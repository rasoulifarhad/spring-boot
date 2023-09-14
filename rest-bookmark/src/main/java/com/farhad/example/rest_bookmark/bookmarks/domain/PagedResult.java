package com.farhad.example.rest_bookmark.bookmarks.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PagedResult<T> {
	private List<T> data;
	private long totalElements;
	private int pageNumber;
	private int totalPages;
	@JsonProperty("isFirst")
	private boolean isFirst;
	@JsonProperty("isLast")
	private boolean isLast;
	@JsonProperty("hasNext")
	private boolean hasNext;
	@JsonProperty("hasPrevious")
	private boolean hasPrevious;
}
;
