package se.nackademin.java20.lab1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.nackademin.java20.lab1.domain.User;
import se.nackademin.java20.lab1.domain.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path="/allAccounts")
    public String getAllUserAccounts(@RequestParam(name="socialSecurityNumber") String socialSecurityNumber, Model model){
        User user = userRepository.findBySocialSecurityNumber(socialSecurityNumber);
        model.addAttribute("allAccounts", user.getAccounts());
        model.addAttribute("pageHeading", "Alla dina konton");
        model.addAttribute("headingName", user.getName());
        return "accounts";
    }

}
