package com.farhad.example.dddlibrary.library.domain.repository;

import com.farhad.example.dddlibrary.library.domain.Reader;

public interface ReaderRepository {

	Reader findById(int readerId);

	void update(Reader reader);
	
}
