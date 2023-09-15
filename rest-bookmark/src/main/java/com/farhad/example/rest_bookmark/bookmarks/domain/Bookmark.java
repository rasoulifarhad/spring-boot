package com.farhad.example.rest_bookmark.bookmarks.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

// Notice that Bookmark is not public. It is package-private scoped class. It is supposed to be used by BookmarkService 
// only and is hidden from outside the package.
//
// Instead of manually setting the createdAt and updatedAt values, we can leverage some of the JPA and Spring Data JPA 
// features to automatically set these values while inserting or updating the entities.
// Using @PrePersist and @PreUpdate
// or
// Using Spring Data JPA’s @CreatedDate and @LastModifiedDate
@Data
@Entity
@Table(name = "bookmarks")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
class Bookmark extends Auditable {;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String url;
	// @Column(name =  "created_at",nullable = false, updatable = false)
	// @CreatedDate
	// private Instant createdAt;
	// @Column(name = "updated_at", insertable = false )
	// @LastModifiedDate
	// private Instant updatedAt;

	// @PreUpdate
	// @PrePersist
	// public void updateTimeStamps() {
	// 	this.updatedAt = Instant.now();
	// 	if(this.createdAt == null) {
	// 		this.createdAt = Instant.now();
	// 	}
	// }

	public Bookmark(String title, String url, Instant createdAt) {
		this.title = title;
		this.url = url;
		this.createdAt = createdAt;
	}
	
	public Bookmark(String title, String url) {
		this.title = title;
		this.url = url;
	}
	
}
