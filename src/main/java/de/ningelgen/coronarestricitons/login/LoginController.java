package de.ningelgen.coronarestricitons.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.ningelgen.coronarestricitons.user.User;
import de.ningelgen.coronarestricitons.user.UserService;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    UserService service;
    
    @GetMapping("/login")
    public String showLogin() {

    service.registerUser(new User("jan", "test123", "jan.ningelgen@student.hs-rm.de"));

        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(Model m, @RequestParam(value="username", required=false) String username, @RequestParam(value="password", required=true) String password) {
        return "welcome";
    }
}
