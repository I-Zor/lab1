package se.nackademin.java20.lab1.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findBySocialSecurityNumber(String socialSecurityNumber);

}
