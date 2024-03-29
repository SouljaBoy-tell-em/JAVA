package com.example.OAuth2;

public class Feature {

    private int id;
    private String name;

    public Feature() {

    }

    public Feature(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Feature(Feature feature) {
        this.id = feature.getId();
        this.name = feature.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
