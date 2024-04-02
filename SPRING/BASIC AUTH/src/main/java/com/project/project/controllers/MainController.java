package com.project.project.controllers;


import com.project.project.requests.JwtAuthResponse;
import com.project.project.user_config.User;
import com.project.project.user_config.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@Controller
@RequestMapping
@SessionAttributes("user")
public class MainController {

    private final String REST_API_AUTHORIZATION_LINK = "http://localhost:8080/auth/sign-in";
    private final String REST_API_REGISTRATION_LINK = "http://localhost:8080/auth/sign-up";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute(name = "user")
    public User User() {
        return new User();
    }

    @GetMapping("/login")
    public String LOGIN() {
        return "login";
    }

    @PostMapping("/profile")
    public String LOGIN_POST(@ModelAttribute(name = "user") User user) {
        user.setRole(UserRole.ROLE_USER);

        RestTemplate restTemplate = new RestTemplate();
        JwtAuthResponse response = restTemplate
                .postForObject(REST_API_REGISTRATION_LINK,user,
                                             JwtAuthResponse.class);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer " + response.getJwtToken());
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> obj = restTemplate.exchange("http://localhost:8080/example",
                HttpMethod.GET,
                entity,
                String.class);

        System.out.println("RESPONSE ENTITY: " + obj.getBody());

        return "profile";
    }

    private void USER_INFO(User user) {
        System.out.println("USERNAME: " + user.getUsername());
        System.out.println("PASSWORD: " + user.getPassword());
        System.out.println("ROLE: "     + user.getRole());
    }
}
