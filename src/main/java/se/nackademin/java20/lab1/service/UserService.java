package se.nackademin.java20.lab1.service;

import org.springframework.stereotype.Service;
import se.nackademin.java20.lab1.domain.User;
import se.nackademin.java20.lab1.domain.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User saveNewUser(String name, String socialSecurityNumber){
        return userRepository.save(new User(name, socialSecurityNumber));
    }

    @Transactional
    public User findUser(String socialSecurityNumber){
        return userRepository.findBySocialSecurityNumber(socialSecurityNumber);
    }
}
