package com.project.project.rabbitmq;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@Controller
@RequestMapping
public class RabbitMQReceiver {
    @RabbitListener(queues = "rabbitmq.queue1")
    public void receive(String message) {
        System.out.println("!!! MESSAGE: " + message);
    }
}