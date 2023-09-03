package com.farhad.example.dddlibrary.library.domain;

import lombok.AllArgsConstructor;

// responsible to answer if the reader can barrow the book
@AllArgsConstructor
public class Reader {
	
	private int readerId;

	public boolean lend(Book book) {
		if (book.canBeBorrowed()) {
			return false;
		}

		return false;
	}

	public boolean canLend(Book book) {
		// copy of book ended
		// reader can already have the max number of books
		// reader account disabled
		// book can be only available in the reading room. 
		// ....
		return false;
	}	
}
