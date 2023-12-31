package com.farhad.example.banking.application.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.banking.domain.port.incoming.DepositUseCase;
import com.farhad.example.banking.domain.port.incoming.WithdrawUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

	private final DepositUseCase depositUseCase;
	private final WithdrawUseCase withdrawUseCase;

	@PostMapping("/{accountNo}/deposit/{depositAmount}")
	public void deposit(@PathVariable final Long accountNo, @PathVariable final BigDecimal depositAmount) {
		depositUseCase.deposit(accountNo, depositAmount);
	}

	@PostMapping("/{accountNo}/withdraw/{withdrawalAmount}")
	public void withdraw(@PathVariable final Long accountNo, @PathVariable final BigDecimal withdrawalAmount) {
		withdrawUseCase.withdraw(accountNo, withdrawalAmount);
	}
	
}
