package com.farhad.example.hexagonalarchitecture.application.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.hexagonalarchitecture.domain.port.incoming.Deposit;
import com.farhad.example.hexagonalarchitecture.domain.port.incoming.Withdraw;

import lombok.RequiredArgsConstructor;

// Next we define the controller class to expose the API for the customer

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
	
	private final Deposit depositUseCase;
	private final Withdraw withdrawUseCase;

	@PostMapping(value = "/{accountNo}/deposit/{depositAmount}")
	void deposit(@PathVariable final Long accountNo, @PathVariable final BigDecimal depositAmount) {
		depositUseCase.deposit(accountNo, depositAmount);
	}

	@PostMapping(value = "/{accountNo}/withdraw/{withdrawalAmount}")
	void withdraw(@PathVariable final Long accountNo, @PathVariable final BigDecimal withdrawalAmount) {
		withdrawUseCase.withdraw(accountNo, withdrawalAmount);
	}
}
