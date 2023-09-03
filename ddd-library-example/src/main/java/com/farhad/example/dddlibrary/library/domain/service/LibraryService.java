package com.farhad.example.dddlibrary.library.domain.service;

import com.farhad.example.dddlibrary.library.domain.Book;
import com.farhad.example.dddlibrary.library.domain.Reader;

public class LibraryService {
	
	public boolean lend(Reader reader, Book book) {
		if (reader.canLend(book)) {
			reader.lend(book);
			return true;
		}
		return false;
	}
}
