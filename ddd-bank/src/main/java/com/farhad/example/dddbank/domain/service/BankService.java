package com.farhad.example.dddbank.domain.service;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.farhad.example.dddbank.domain.model.AccountAccessRepository;
import com.farhad.example.dddbank.domain.model.Client;
import com.farhad.example.dddbank.domain.model.ClientRepository;
import com.farhad.example.dddbank.domain.shared.Amount;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankService {
    
    private final ClientRepository clientRepository;
	private final AccountAccessRepository accountAccessRepository;

    public Client createClient(final String username, final LocalDate birthDate) {
        requireNonNull(username);
        requireNonNull(birthDate);
        final Pattern pattern = Pattern.compile("[a-z_A-Z][a-z_A-Z0-9]{0,30}");
        if(!pattern.matcher(username).matches()) {
            throw new RuntimeException();
        }
        return clientRepository.save(new Client(username, birthDate));
    }

	public void deleteClient(final Client client) {
        accountAccessRepository
            .findManagedAccountsOf(client, false)
                .forEach(accountAccess ->  accountAccessRepository.delete(accountAccess));
        clientRepository.delete(client);
    }
    
    public Client findClient(final String username)  {
        return clientRepository.findByUserName(username)
                    .orElseThrow(() -> new RuntimeException());
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public List<Client> findYoungClients(final LocalDate fromBirth) {
        return clientRepository.findAllBornFrom(fromBirth);
    }

    public List<Client> findRichClients(final Amount minBalance) {
        return accountAccessRepository.findFullAccounts(minBalance)
                    .stream()
                        .map(acc -> acc.getClient())
                        .collect(toList());
    }
}
