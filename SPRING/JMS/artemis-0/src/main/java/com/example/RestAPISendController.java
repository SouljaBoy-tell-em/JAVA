package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RestAPISendController {

    private JmsTemplate jmsTemplate;

    @Autowired
    public RestAPISendController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping(value = "/send/{message}", produces = "text/html")
    public String sendMessage(@PathVariable("message") String message) {
        jmsTemplate.convertAndSend("queue1", message);
        return "message: done";
    }
}
