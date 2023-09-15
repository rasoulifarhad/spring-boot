package com.farhad.example.hexagonalbankaccount.adapters.web;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.hexagonalbankaccount.application.domain.AccountId;
import com.farhad.example.hexagonalbankaccount.application.domain.Money;
import com.farhad.example.hexagonalbankaccount.application.port.incoming.DepositUseCase;
import com.farhad.example.hexagonalbankaccount.application.port.incoming.WithdrawUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class BankAccountController {
	
	private final DepositUseCase depositUseCase;
	private final WithdrawUseCase withdrawUseCase;

	@PostMapping("/{id}/withdraw/{amount}")
	public void withdraw(@PathVariable(name = "id") final Long id, 
						@PathVariable(name = "amount") final BigDecimal amount) {
		withdrawUseCase.withdraw(new AccountId(id), new Money("EUR", amount));

	}

	@PostMapping("/{id}/deposit/{amount}")
	public void deposit(@PathVariable(name = "id") final Long id, 
						@PathVariable(name = "amount") final BigDecimal amount) {
		depositUseCase.deposit(new AccountId(id), new Money("EUR", amount));

	}

}
