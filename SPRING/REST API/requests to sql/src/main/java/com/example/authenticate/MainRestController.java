package com.example.authenticate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// @CrossOrigin - способность общаться указанным в origins параметров друг с другом
// например: @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
// localhost:8080 и localhost:8081 могут общаться друг с другом, а с другими хостами нет.

@RestController
@RequestMapping(path = "api/users", produces = {"application/json"})
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
public class MainRestController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public MainRestController(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping
    public List<User> GetUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> GetUserById(@PathVariable("id") int id) {

        return userRepository.findById(id);
    }

//    @PostMapping(consumes = "application/json", path = "/rest")
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User AddUser(@RequestBody User user) {

//        User saveUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()));
        User saveUser = new User(user);
        userRepository.save(saveUser);
        return saveUser;
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }

////  обработка HttpStatus, а именно проверка на существование user-a;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> GetUserById(@PathVariable("id") int id) {
//
//        Optional<User> user = userRepository.findById(id);
//
//        if(user.isPresent())
//            return new ResponseEntity<>(user.get(), HttpStatus.OK);
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }

}
