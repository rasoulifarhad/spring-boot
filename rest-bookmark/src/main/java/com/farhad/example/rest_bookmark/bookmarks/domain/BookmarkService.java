package com.farhad.example.rest_bookmark.bookmarks.domain;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookmarkService {
	
	private final BookmarkRepository bookmarkRepository;

	public PagedResult<BookmarkDTO> findBookmarks(FindBookmarkQuery query) {
		Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
	    //from user POV, page number starts from 1, but for Spring Data JPA page number starts from 0.
		int pageNo = query.getPageNo() > 0 ? query.getPageNo() - 1 : 0; 
		Pageable pageable = PageRequest.of(pageNo,query.getPageSize(), sort);
		Page<BookmarkDTO> page = bookmarkRepository.findBookmarks(pageable);
		return new PagedResult<>(
			page.getContent(), 
			page.getTotalElements(), 
			page.getNumber() + 1, // for user page number starts from 1
			page.getTotalPages(), 
			page.isFirst(), 
			page.isLast(), 
			page.hasNext(), 
			page.hasPrevious());
	}

	@Transactional
	public BookmarkDTO create(CreateBookmarkCommand cmd) {
		// Bookmark bookmark = new Bookmark(cmd.getTitle(), cmd.getUrl(), Instant.now());
		Bookmark bookmark = new Bookmark(cmd.getTitle(), cmd.getUrl());
		bookmark = bookmarkRepository.save(bookmark);
		return BookmarkDTO.from(bookmark);
	}

	@Transactional
	public void update(UpdateBookmarkCommand cmd) {
		Bookmark bookmark = 
			bookmarkRepository.findById(cmd.getId())
				.orElseThrow(() -> BookmarkNotFpundException.of(cmd.getId()));
		bookmark.setTitle(cmd.getTitle());
		bookmark.setUrl(cmd.getUrl());
		// bookmark.setUpdatedAt(Instant.now());
		bookmarkRepository.save(bookmark);
	}
	
	public Optional<BookmarkDTO> findById(Long id) {
		return bookmarkRepository.findBookmarkById(id);
	}

	@Transactional
	public void delete(Long id) {
		Bookmark bookmark = bookmarkRepository
									.findById(id)
									.orElseThrow(() -> BookmarkNotFpundException.of(id));
		bookmarkRepository.delete(bookmark);
	}
}
