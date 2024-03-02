package com.project.project;


import com.project.project.repositories.UserRepository;
import com.project.project.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class RestAPIController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get")
    public List<User> get() {
        List<User> list = userRepository.findAll();
        return list;
    }
}
