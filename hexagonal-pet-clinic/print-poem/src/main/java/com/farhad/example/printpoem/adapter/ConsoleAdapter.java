package com.farhad.example.printpoem.adapter;

import com.farhad.example.printpoem.domain.RequestVersesPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsoleAdapter {
	
	private final RequestVersesPort poetryReader;
	private final WriteStuffOnTheConsole  writeStrategy;

	
	public ConsoleAdapter(RequestVersesPort poetryReader) {
		this(poetryReader, new DefaultPublicationStrategy());
	}

	public void ask() {
		String verses = poetryReader.giveMeSomePoetry();

		writeStrategy.WriteLine(String.format("A beautiful poem:%n%n%s", verses ));
	}

	private static class DefaultPublicationStrategy implements WriteStuffOnTheConsole {

		@Override
		public void WriteLine(String text) {
			System.out.print(text);
			System.out.println();
		}

	}
}
