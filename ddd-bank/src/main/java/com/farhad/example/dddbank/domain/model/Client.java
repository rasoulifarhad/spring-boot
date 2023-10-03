package com.farhad.example.dddbank.domain.model;

import java.time.LocalDate;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.farhad.example.dddbank.domain.shared.Amount;
import com.farhad.example.dddbank.domain.shared.EntityBase;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class Client extends EntityBase<Client> {

    @Column(unique = true, nullable = false)
    private String username;

	private LocalDate birthDate;
    
    public Client(final String username, final LocalDate birthDate) {
        this.username = username;
        this.birthDate = birthDate;
    }

    public AccountAccess createAccount(final String accountName, 
                        final AccountAccessRepository accountAccessRepository,
                        final AccountRepository accountRepository) {
        Account account = accountRepository.save(new Account(accountName));
        return accountAccessRepository.save(
            new AccountAccess(this, true, account));
    }

    public void deposit(final AccountNo destination, final Amount amount, 
                        final AccountAccessRepository accountAccessRepository,
                        final AccountRepository accountRepository){
        Account account = 
            accountRepository.findByAccountNo(destination)
                            .orElseThrow(() -> new RuntimeException("Account not found"));
        account.deposit(amount);
        accountRepository.save(account);
    }

    public void transfer(final Account source, 
                        final AccountNo destinationAccountNo, 
                         final Amount amount, 
                        final AccountAccessRepository accountAccessRepository,
                        final AccountRepository accountRepository){
        validateAmount(amount);
        checkRightAccessFor(source,accountAccessRepository);
        
        Account destination =  
            accountRepository.findByAccountNo(destinationAccountNo)
                    .orElseThrow(() -> new RuntimeException());
        
        source.withdrawn(amount);
        destination.deposit(amount);

        accountRepository.save(source);
        accountRepository.save(destination);
    }

    private void checkRightAccessFor(Account account, 
                            AccountAccessRepository repository) {
        repository.find(this, account)
                .orElseThrow(() -> new RuntimeException());
    }

    private void validateAmount(Amount amount) {
        if (amount.signum() == -1 ) {
			throw new RuntimeException();
		}
    }

    public AccountAccess addAccountManager(final Account account, Client manager,
                        final AccountAccessRepository accountAccessRepository,
                        final AccountRepository accountRepository) {  
        AccountAccess accountAccess = accountAccessRepository.find(this, account)
                 .filter(ac -> ac.isOwner())
                 .orElseThrow(() -> new RuntimeException());
        return accountAccessRepository.find(manager, account)
                    .map(t -> Stream.<AccountAccess>empty())
                    .orElseGet(() -> Stream.<AccountAccess>of(new AccountAccess(manager, false, account)))
                    .map(acc -> accountAccessRepository.save(accountAccess))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException());
    } 

    public Account findMyAccount(final AccountNo accountNo, 
                        final AccountAccessRepository accountAccessRepository,
                        final AccountRepository accountRepository)  {
        return accountRepository.findByAccountNo(accountNo)
                       .flatMap(a -> accountAccessRepository.find(this, a))
                       .map(a -> a.getAccount())
                       .orElseThrow(() -> new RuntimeException());
    }
	public String accountsReport( 
                        final AccountAccessRepository accountAccessRepository,
                        final AccountRepository accountRepository) {
        return "";
    }   
    
    // void provideWith(final AccountAccessRepository accountAccessRepository,
	// 		final AccountRepository accountRepository) {
	// 	this.accountAccessRepository = accountAccessRepository;
	// 	this.accountRepository = accountRepository;
	// }
    // private transient AccountAccessRepository accountAccessRepository;
	// private transient AccountRepository accountRepository;
}
