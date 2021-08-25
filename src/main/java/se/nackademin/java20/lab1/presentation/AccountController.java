package se.nackademin.java20.lab1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.nackademin.java20.lab1.domain.User;
import se.nackademin.java20.lab1.domain.UserRepository;

@Controller
public class AccountController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/startPage")
    public String StartPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "startPage.html";
    }

    @GetMapping("/user/myAccounts")
    public String MyAccounts(@RequestParam String pn, Model model){
        User user = userRepository.findBySocialSecurityNumber(pn);
        model.addAttribute("pn", user);
        return "myAccounts.html";
    }

}
