package se.nackademin.java20.lab1.Services;

import org.springframework.stereotype.Service;
import se.nackademin.java20.lab1.domain.Account;
import se.nackademin.java20.lab1.domain.AccountRepository;
import se.nackademin.java20.lab1.domain.User;
import se.nackademin.java20.lab1.domain.UserRepository;
import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public User addUser(String name, String socialSecurityNumber){
        return userRepository.save(new User(name, socialSecurityNumber));
    }

    @Transactional
    public User findUserBySocialSecurityNumber(String socialSecurityNumber){
        return userRepository.findBySocialSecurityNumber(socialSecurityNumber);
    }

    @Transactional
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public void addAccountToUser(String socialSecurityNumber, int accountNumber){
        User user = userRepository.findBySocialSecurityNumber(socialSecurityNumber);
        accountRepository.save(new Account(accountNumber, user));
    }
}

