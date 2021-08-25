package se.nackademin.java20.lab1.Persistance;


import org.springframework.data.repository.CrudRepository;
import se.nackademin.java20.lab1.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findBySocialSecurityNumber(String ssn);
}
