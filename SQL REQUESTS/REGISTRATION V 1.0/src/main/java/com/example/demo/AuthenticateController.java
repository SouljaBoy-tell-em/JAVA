package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authenticate")
public class AuthenticateController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AuthenticateController(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/register")
    public String RegisterUser() {
        return "register";
    }

    @PostMapping("/register")
    public String RegisterUserRedirect() {
        return "redirect:/register/main";
    }

    @PostMapping("/register/main")
    public String registerMain(@ModelAttribute("user") User user) {

        userRepository.save(new User(user.getName(),
                                passwordEncoder.encode(user.getPassword()),
                                user.getCity(),
                                user.getStreet(),
                                user.getHome(),
                                user.getBuilding(),
                                user.getStage(),
                                user.getFlat()));
        return "main";
    }
}
