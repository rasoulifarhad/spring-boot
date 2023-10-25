package com.farhad.example.discount.outside.foradiscounting.cli;

import java.util.Scanner;

import com.farhad.example.discount.application.Amount;
import com.farhad.example.discount.application.ports.driving.ForDiscounting;
import com.farhad.example.discount.outside.Driver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandLineInterface implements Driver {

	private final ForDiscounting discounterApp;

	@Override
	public void run(String... args) {

		boolean exit = false;
		printInfo();
		Scanner scanner = new Scanner(System.in);
		while (!exit) {
			printAppMenu();
			exit = handlecommand(scanner);
		}
	}

	private boolean handlecommand(Scanner scanner) {
		try {
			String option = scanner.next();
			switch (option) {
				case "1":
					option1(scanner);
					return false;
				case "2":
					return true;
				default:
					System.out.println("Invalid option");
					return false;
			}
		} catch (Exception e) {
			System.out.println("Unexpected error");
			e.printStackTrace();
		}
		return false;
	}

	private void option1(Scanner scanner) {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Enter an amount:");
		String amount = scanner.next();
		System.out.println("The discount is:");
		Amount discount = this.discounterApp.calculateDiscount(Amount.parse(amount));
		System.out.println(discount.toString());
	}

	private void printAppMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("-------------------");
		System.out.println("DISCOUNTER APP MENU");
		System.out.println("-------------------");
		System.out.println("(1) Calculate discount.");
		System.out.println("(2) Exit.");
		System.out.println("Choose an option:");
	}

	private void printInfo() {
		System.out.println("===============================================");
		System.out.println("Running CLI");
		System.out.println("===============================================");
	}

}
