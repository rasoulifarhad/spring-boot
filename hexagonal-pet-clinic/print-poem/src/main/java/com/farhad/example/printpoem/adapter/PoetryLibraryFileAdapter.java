package com.farhad.example.printpoem.adapter;

import java.io.File;

import com.farhad.example.printpoem.domain.ObtainPoemsPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PoetryLibraryFileAdapter implements ObtainPoemsPort {

	private final File file;

	@Override
	public String getAPoem() {
		return null;
	}
	
}
