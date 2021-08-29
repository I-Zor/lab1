package se.nackademin.java20.lab1.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.domain.Account;
import se.nackademin.java20.lab1.service.AccountService;

@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/startPage")
    public String StartPage(Model model){
        String socialSecurityNumber = "";
        model.addAttribute("socialSecurityNumber", socialSecurityNumber);
        return "startPage.html";
    }

    @GetMapping("/account/update/{id}")
    public String accountForm(@PathVariable("id") int id, Model model){
        Account account = accountService.findAccount(id);
        model.addAttribute("saldo", account.getCurrentBalance());
        model.addAttribute("headingName", account.getAccountNumber());

        return "saldo";

    }

    @PostMapping("/account/update/{id}/deposit")
    public String deposit(@PathVariable("id") int id, @RequestParam (name="deposit") double deposit, Model model ){
        Account account = accountService.deposit(id, deposit);
        return "redirect:/account/update/"+ account.getAccountNumber();

    }

    @PostMapping("/account/update/{id}/withdraw")
    public String withdraw(@PathVariable("id") int id, @RequestParam (name="withdraw") double withdraw, Model model ) {
       Account account = accountService.withdraw(id, withdraw);
        return "redirect:/account/update/" + account.getAccountNumber();
    }

}
