package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequestMapping
@Controller
public class MainController {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public MainController() {}

    @GetMapping("/register")
    public String Register() {
        return "register";
    }

    @GetMapping("/news")
    public String News() {
        return "news";
    }

    @GetMapping("/profile")
    public String main() {
        return "profile";
    }

    @PostMapping
    public String RedirectMainPage(@ModelAttribute User user) {
        return "redirect:/profile";
    }

    @PostMapping("/profile")
    public String MainPage(@ModelAttribute(name = "user") User user) {
        USER_INFO(user);
        userRepository.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword())));
        return "profile";
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    private void USER_INFO(User user) {
        System.out.println("User name: " + user.getUsername());
        System.out.println("User password: " + user.getUsername());
    }

    private void USER_INFO2() {
        User user = userRepository.findById("user").get();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}
