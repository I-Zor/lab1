package se.nackademin.java20.lab1.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private long id;

    private int accountNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @JsonManagedReference
    private User user;

    private double currentBalance;

    public Account(int accountNumber, User user) {
        this.accountNumber = accountNumber;
        this.user = user;
        this.currentBalance = 0;
    }

    public Account() {
    }

    public double deposit (double amount){
        return this.currentBalance += amount;
    }

    public double withdraw (double amount){
        if (amount > this.currentBalance){
            throw new IllegalStateException("Balance cannot be less than 0");
        }
        return this.currentBalance -= amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public User getUser() {
        return user;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
}
