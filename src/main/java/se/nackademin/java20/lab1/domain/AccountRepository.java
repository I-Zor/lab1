package se.nackademin.java20.lab1.domain;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByAccountNumber(int accountNumber);



}
