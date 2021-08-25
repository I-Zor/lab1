package se.nackademin.java20.lab1.Persistance;

import org.springframework.data.repository.CrudRepository;
import se.nackademin.java20.lab1.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
