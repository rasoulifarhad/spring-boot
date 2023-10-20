package com.farhad.example.printpoem;

import java.io.File;
import java.util.Scanner;

import com.farhad.example.printpoem.adapter.ConsoleAdapter;
import com.farhad.example.printpoem.adapter.PoetryLibraryFileAdapter;
import com.farhad.example.printpoem.domain.ObtainPoemsPort;
import com.farhad.example.printpoem.domain.PoetryReader;
import com.farhad.example.printpoem.domain.RequestVersesPort;

public class PrintPoemApplication {

	public static void main(String[] args) {
	      // 1. Instantiate right-side adapter ("go outside the hexagon")
		  ObtainPoemsPort fileAdapter = new PoetryLibraryFileAdapter(new File("Peoms.txt"));

		  // 2. Instantiate the hexagon
		  RequestVersesPort poetryReader = new PoetryReader(fileAdapter);
  
		  // 3. Instantiate the left-side adapter ("I want ask/to go inside")
		  ConsoleAdapter consoleAdapter = new ConsoleAdapter(poetryReader);
  
		  System.out.println("Here is some...");
		  consoleAdapter.ask();
  
		  System.out.println("Type enter to exit...");
		  Scanner scanner = new Scanner(System.in);
		  while(scanner.hasNext()) {
			String line = scanner.nextLine();
		  }
		  scanner.close();
	}

}
