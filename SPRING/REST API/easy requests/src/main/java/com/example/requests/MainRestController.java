package com.example.requests;

import com.sun.tools.javac.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/objects", produces = "application/json")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8080"})
public class MainRestController {

    private ArrayList<String> objects;

    public MainRestController() {
        objects = new ArrayList<>();
        objects.add("DEFAULT 0");
        objects.add("DEFAULT 1");
    }

    @GetMapping
    public ArrayList<String> GetObjects() {
        return objects;
    }

    @GetMapping("/{id}")
    public String GetObjectID(@PathVariable("id") int id) {
        return objects.get(id);
    }

    @PostMapping
    public String AddObject(@RequestBody String object) {

        objects.add(object);
        return object;
    }

    @DeleteMapping("/{id}")
    public void DeleteObjectID(@PathVariable("id") int id) {

        objects.remove(id);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
