package com.example.authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

// @CrossOrigin - способность общаться указанным в origins параметров друг с другом
// например: @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
// localhost:8080 и localhost:8081 могут общаться друг с другом, а с другими хостами нет.

@RestController
@RequestMapping(path = "api/users", produces = "application/json")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
public class MainRestController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RestTemplate restTemplate;

    public MainRestController(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.restTemplate = new RestTemplate();
    }

    @GetMapping
    public List<User> GetUsers() {

        UserFactory user = new UserFactory("p228", passwordEncoder.encode("u228"));
        AddUserRest(user);
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> GetUserById(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public User AddUser(@RequestBody UserFactory userFactory) {

        User user = new User(userFactory);
        userRepository.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }

    public void AddUserRest(UserFactory userFactory) {

        restTemplate.postForObject("http://localhost:8080/api/users", userFactory, UserFactory.class);
    }
}
