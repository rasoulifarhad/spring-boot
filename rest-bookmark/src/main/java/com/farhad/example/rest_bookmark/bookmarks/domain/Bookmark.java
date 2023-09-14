package com.farhad.example.rest_bookmark.bookmarks.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// Notice that Bookmark is not public. It is package-private scoped class. It is supposed to be used by BookmarkService 
// only and is hidden from outside the package.

@Data
@Entity
@Table(name = "bookmarks")
class Bookmark {;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String url;
	@Column(name =  "create_at",nullable = false, updatable = false)
	private Instant createdAt;
	@Column(name = "updated_at", insertable = false )
	private Instant updatedAt;
	
}
