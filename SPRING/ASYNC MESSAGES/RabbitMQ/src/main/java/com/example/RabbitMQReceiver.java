package com.example;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
@RequestMapping
public class RabbitMQReceiver {

//    private RabbitTemplate rabbitTemplate;
//    private MessageConverter converter;
//
//    @Autowired
//    public RabbitMQReceiver(RabbitTemplate rabbitTemplate, MessageConverter converter) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.converter = rabbitTemplate.getMessageConverter();
//    }
//
//    @GetMapping("/get_message")
//    public void receive() {
//
//    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receive(String message) {
        System.out.println("!!! MESSAGE: " + message);
    }
}
