package com.example;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
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
