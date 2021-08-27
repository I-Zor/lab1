package se.nackademin.java20.lab1.Services;

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
    public void saveUser(User user){
        userRepository.save(user);
    }
}

