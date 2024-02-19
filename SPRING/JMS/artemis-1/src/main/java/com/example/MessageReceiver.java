package com.example;


import jakarta.jms.JMSException;
import org.springframework.jms.support.converter.MessageConverter;
import jakarta.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class MessageReceiver {

    private JmsTemplate jmsTemplate;
    private MessageConverter converter;

    @Autowired
    public MessageReceiver(JmsTemplate jmsTemplate, MessageConverter converter) {
        this.jmsTemplate = jmsTemplate;
        this.converter   =   converter;
    }

    @GetMapping("/get_message")
    public String GET_MESSAGE() throws JMSException {
        Message message = jmsTemplate.receive("queue1");
        return "receive:" + (String) converter.fromMessage(message);
    }
}
