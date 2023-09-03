package com.farhad.example.dddlibrary.library.application.service;

import com.farhad.example.dddlibrary.library.domain.Book;
import com.farhad.example.dddlibrary.library.domain.Reader;
import com.farhad.example.dddlibrary.library.domain.repository.BookRepository;
import com.farhad.example.dddlibrary.library.domain.repository.ReaderRepository;
import com.farhad.example.dddlibrary.library.domain.service.LibraryService;

import lombok.AllArgsConstructor;

// Application library service
@AllArgsConstructor
public class LibraryUseCase {
	
	private LibraryService libraryService;
	private NotificationService notificationService;
	private ReaderRepository readerRepository;
	private BookRepository bookRepository;

	public boolean lend(int readerId, int bookId) {
		Reader reader = readerRepository.findById(readerId);
		Book book = bookRepository.findById(bookId);
		if (libraryService.lend(reader, book)) {
			readerRepository.update(reader);
			bookRepository.update(book);
			notificationService.sendEmailAboutLoan(book, reader);
			return  true;
		}
		return false;
	}
}
