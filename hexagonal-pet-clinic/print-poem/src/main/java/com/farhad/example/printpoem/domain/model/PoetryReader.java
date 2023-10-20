package com.farhad.example.printpoem.domain.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PoetryReader implements RequestVersesPort{

	private final ObtainPoemsPort poetryLibrary;

	@Override
	public String giveMeSomePoetry() {
		if(poetryLibrary != null ) {
			return poetryLibrary.getAPoem();	
		}
		return "If you could read a leaf or tree\r\nyou’d have no need of books.\r\n-- © Alistair Cockburn (1987)";
	}
}
