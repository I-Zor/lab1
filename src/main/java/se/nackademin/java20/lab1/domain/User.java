package se.nackademin.java20.lab1.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String socialSecurityNumber;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private final List<Account> accounts = new ArrayList<>();

    public User(String name, String socialSecurityNumber) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;

    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount (Account account){
        this.accounts.add(account);
    }
}
