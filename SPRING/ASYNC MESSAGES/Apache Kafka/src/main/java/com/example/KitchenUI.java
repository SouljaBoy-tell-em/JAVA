package com.example;


import org.springframework.stereotype.Component;

@Component
public class KitchenUI {
    public void recieve(String message) {
        System.out.println("!!! MESSAGE: " + message);
    }
}
