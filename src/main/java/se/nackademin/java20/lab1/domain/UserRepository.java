package se.nackademin.java20.lab1.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    User findBySocialSecurityNumber(String socialSecurityNumber);

}
