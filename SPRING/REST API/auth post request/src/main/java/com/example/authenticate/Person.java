package com.example.authenticate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Person {

    @Id
    private int id;
    private String name;
    private String password;

    public Person() {}
    public Person(String name, String password) {

        this.name = name;
        this.password = password;
    }
    public Person(Person person) {

        this.id = person.getId();
        this.name = person.getName();
        this.password = person.getPassword();
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
