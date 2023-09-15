// package com.farhad.example.hexagonalbankaccount.adapters.persistence;

// import java.util.Optional;

// import org.springframework.stereotype.Component;

// import com.farhad.example.hexagonalbankaccount.application.domain.AccountId;
// import com.farhad.example.hexagonalbankaccount.application.domain.BankAccount;
// import com.farhad.example.hexagonalbankaccount.application.port.outgoing.LoadAccountPort;
// import com.farhad.example.hexagonalbankaccount.application.port.outgoing.PersistAccountPort;

// import lombok.RequiredArgsConstructor;

// @Component
// @RequiredArgsConstructor
// public class BankAccountRepository implements LoadAccountPort, PersistAccountPort {

// 	private final SpringDataBankAccountRepository repository;
	
// 	@Override
// 	public void save(BankAccount bankAccount) {
// 		repository.save(bankAccount);
// 	}

// 	@Override
// 	public Optional<BankAccount> findById(AccountId id) {
// 		return repository.findById(id);
// 	}
	
// }
