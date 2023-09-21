package com.example.authenticate;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class MainController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public MainController(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping
    public String Main() {

//        List<User> users = userRepository.findAll();
//        for(int indexUser = 0; indexUser < users.size(); indexUser++) {
//
//            System.out.println();
//            System.out.println("#################################");
//            System.out.println("id: " + users.get(indexUser).getId());
//            System.out.println("name: " + users.get(indexUser).getUsername());
//            System.out.println("password: " + users.get(indexUser).getPassword());
//            System.out.println("#################################");
//        }

        return "main";
    }

    @GetMapping("/register")
    public String Register() {
        return "register";
    }

    @PostMapping("/register")
    public String RedirectRegister() {
        return "redirect:/";
    }

    @PostMapping
    public String PostRedirectRegister(@ModelAttribute("user") User user) {

        userRepository.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword())));
        return "main";
    }

    @GetMapping("/accept_auth")
    public String AcceptAuth() {
        return "accept_auth";
    }

    @GetMapping("/login")
    public String Auth() {
        return "login";
    }

    @GetMapping("/content")
    public String Content() {
        return "content";
    }

    @RequestMapping("/request")
    public String Request(HttpServletRequest request) {

        System.out.println("SERVLET TEST: " + request.getRequestURL());

        return "main";
    }
}
