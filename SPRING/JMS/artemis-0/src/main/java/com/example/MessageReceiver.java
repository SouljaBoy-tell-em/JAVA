package com.example;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @JmsListener(destination = "queue1")
    public void ReceiveMessage(String message) {
        System.out.println("MESSAGE: " + message);
    }
}
