package se.nackademin.java20.lab1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.Services.UserService;
import se.nackademin.java20.lab1.domain.Account;
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
    public String getUserAccounts(@RequestParam(name="socialSecurityNumber") String socialSecurityNumber, Model model){
        User user = userService.findUserBySocialSecurityNumber(socialSecurityNumber);
        model.addAttribute("allAccounts", user.getAccounts());
        model.addAttribute("pageHeading", "Alla dina konton");
        model.addAttribute("headingName", user.getName());
        model.addAttribute("user", user);
        return "accounts";
    }

    @PostMapping(path="/newUser")
    public String addNewUser(@RequestParam(name="socialSecurityNumber") String socialSecurityNumber,@RequestParam(name="name") String name, Model model){
        final User newUser = userService.addUser(name, socialSecurityNumber);
        return "redirect:allAccounts?socialSecurityNumber="+newUser.getSocialSecurityNumber();
    }

    @PostMapping(path="/addAccount/{socialSecurityNumber}")
    public String addNewAccount(@PathVariable String socialSecurityNumber, @RequestParam(name="number") int accountNumber, Model model){
       userService.addAccountToUser(socialSecurityNumber, accountNumber);
        return "redirect:/user/allAccounts?socialSecurityNumber="+socialSecurityNumber;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
