package se.nackademin.java20.lab1.service;

import org.springframework.stereotype.Service;
import se.nackademin.java20.lab1.domain.Account;
import se.nackademin.java20.lab1.domain.AccountRepository;
import se.nackademin.java20.lab1.domain.User;

import javax.transaction.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account findAccount(int accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Transactional
    public Account deposit(int accountNumber, double amount){
        Account account = findAccount(accountNumber);
        account.deposit(amount);
        accountRepository.save(account);
        return account;
    }

    @Transactional
    public Account withdraw(int accountNumber, double amount){
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
        accountRepository.save(account);
        return account;
    }

}
