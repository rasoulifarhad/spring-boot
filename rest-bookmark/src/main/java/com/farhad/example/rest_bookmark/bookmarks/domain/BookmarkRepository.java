package com.farhad.example.rest_bookmark.bookmarks.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Notice that BookmarkRepository is not public. It is package-private scoped interface. It is supposed to be used by BookmarkService 
// only and is hidden from outside the package.
interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
	@Query(" SELECT new com.farhad.example.rest_bookmark.bookmarks.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) FROM Bookmark b ")
	Page<BookmarkDTO> findBookmarks(Pageable pageable);
}
