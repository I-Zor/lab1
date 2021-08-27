package se.nackademin.java20.lab1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.domain.Account;
import se.nackademin.java20.lab1.domain.AccountRepository;
import se.nackademin.java20.lab1.domain.User;
import se.nackademin.java20.lab1.domain.UserRepository;

@Controller
public class AccountController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/startPage")
    public String StartPage(Model model){
        String socialSecurityNumber = "";
        model.addAttribute("socialSecurityNumber", socialSecurityNumber);
        return "startPage.html";
    }

    @GetMapping("/account/update/{id}")
    public String accountForm(@PathVariable("id") int id, Model model){
        Account account = accountRepository.findByAccountNumber(id);
        System.out.println(account.getAccountNumber());
        model.addAttribute("saldo", account.getCurrentBalance());
        model.addAttribute("headingName", account.getAccountNumber());

        return "saldo";

    }

    @PostMapping("/account/update/{id}/deposit")
    public String deposit(@PathVariable("id") int id, @RequestParam (name="deposit") double deposit, Model model ){
        Account account = accountRepository.findByAccountNumber(id);
        account.deposit(deposit);
        accountRepository.save(account);
        return "redirect:/account/update/"+ id;

    }

    @PostMapping("/account/update/{id}/withdraw")
    public String withdraw(@PathVariable("id") int id, @RequestParam (name="withdraw") double withdraw, Model model ) {
        Account account = accountRepository.findByAccountNumber(id);
        account.withdraw(withdraw);
        accountRepository.save(account);
        return "redirect:/account/update/" + id;
    }

}
