package com.example.authenticate;

import com.sun.tools.javac.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/objects", produces = "application/json")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8080"})
public class SecondRestController {

    private ArrayList<String> objects;
    private RestTemplate restTemplate;

    public SecondRestController() {

        restTemplate = new RestTemplate();

        objects = new ArrayList<>();
        objects.add("DEFAULT 0");
        objects.add("DEFAULT 1");
    }

    @GetMapping
    public ArrayList<String> GetObjects() {

        String object = "new_object1";
        AddObjectRest(object);
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

    private void AddObjectRest(String object) {
        restTemplate.postForObject("http://localhost:8080/api/objects", object, String.class);
    }
}

