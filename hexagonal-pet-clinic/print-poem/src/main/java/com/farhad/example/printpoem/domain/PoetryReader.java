package com.farhad.example.printpoem.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PoetryReader implements RequestVersesPort{

	private final ObtainPoemsPort poetryLibrary;

	@Override
	public String giveMeSomePoetry() {
		String str = null;
		if(poetryLibrary != null ) {
			str = poetryLibrary.getAPoem();	
		}
		return str == null ? 
				"If you could read a leaf or tree\r\nyou’d have no need of books.\r\n-- © Alistair Cockburn (1987)" :
				str;
	}
}
