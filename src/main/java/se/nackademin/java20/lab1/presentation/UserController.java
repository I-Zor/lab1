package se.nackademin.java20.lab1.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.nackademin.java20.lab1.domain.User;
import se.nackademin.java20.lab1.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="/allAccounts")
    public String getAllUserAccounts(@RequestParam(name="socialSecurityNumber") String socialSecurityNumber, Model model){
        User user = userService.findUser(socialSecurityNumber);
        model.addAttribute("allAccounts", user.getAccounts());
        model.addAttribute("pageHeading", "Alla dina konton");
        model.addAttribute("headingName", user.getName());

        return "accounts";
    }

}
