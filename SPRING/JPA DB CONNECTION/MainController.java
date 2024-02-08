package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping
@Controller
public class MainController {
    
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String Register() {
        return "register";
    }

    @PostMapping
    public String RedirectMainPage(@ModelAttribute User user) {
        return "redirect:/main";
    }

    @PostMapping("/main")
    public String MainPage(@ModelAttribute(name = "user") User user) {
        USER_INFO(user);
        userRepository.save(user);
        return "main";
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    private void USER_INFO(User user) {
        System.out.println("User name: " + user.getId());
        System.out.println("User password: " + user.getUsername());
    }
}
