package com.example.authenticate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// @CrossOrigin - способность общаться указанным в origins параметров друг с другом
// например: @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
// localhost:8080 и localhost:8081 могут общаться друг с другом, а с другими хостами нет.

@RestController
@RequestMapping(path = "api/users", produces = {"application/json"})
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"}, maxAge = 3000)
public class MainRestController {

    private UserRepository userRepository;

    public MainRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/rest")
    public List<User> GetUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> GetUserById(@PathVariable("id") int id) {

        return userRepository.findById(id);
    }

    @PostMapping(consumes = "application/json", path = "/rest")
//    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User AddUser(@RequestBody User user) {

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }

    // обработка HttpStatus, а именно проверка на существование user-a;
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
