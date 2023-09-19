package com.example.authenticate;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping(path = "/api/users", produces = "application/json")
public class MainRestController {

    private UserRepository userRepository;

    public MainRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping(params = "recent")
    public List<User> recentUsers() {

    }
}
