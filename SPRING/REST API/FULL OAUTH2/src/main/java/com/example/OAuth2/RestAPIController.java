package com.example.OAuth2;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin(origins = "http://localhost:9000")
public class RestAPIController {
    private List<Feature> features1 = new ArrayList<>();
    private List<Feature> features2 = new ArrayList<>();
    private RestTemplate restTemplate = new RestTemplate();

    public RestAPIController() {
        features1.add(new Feature(0, "feature0_name"));
        features1.add(new Feature(1, "feature1_name"));
        features1.add(new Feature(2, "feature2_name"));

        features2.add(new Feature(3, "feature3_name"));
        features2.add(new Feature(4, "feature4_name"));
    }

    @GetMapping("/features1")
    public List<Feature> GET_FEATURES1() {
//        Map<String, Integer> mapId = new HashMap<>();
//        mapId.put("id", 1);
//        System.out.println(restTemplate.getForObject("http://localhost:8080/users1/{id}", User.class, mapId).getUsername());

        return features1;
    }

    @GetMapping("/features2")
    public List<Feature> GET_USERS2() {
        return features2;
    }

    @GetMapping("/features1/{id}")
    public Feature GET_FEATURE1(@PathVariable("id") int id) {
        return features1.get(id);
    }

    @GetMapping("/features2/{id}")
    public Feature GET_FEATURE2(@PathVariable("id") int id) {
        return features2.get(id);
    }

    @PostMapping("/features1")
    public void POST_FEATURE1(@RequestBody Feature feature) {
        features1.add(new Feature(feature));
    }

    @DeleteMapping("/features1/{id}")
    public void DELETE_FEATURE1(@PathVariable("id") int id) {
        features1.remove(id);
    }

}