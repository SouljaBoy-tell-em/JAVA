package com.project.project.rabbitmq;


import com.project.project.DB.SQLTableManager;
import com.project.project.repositories.UserRepository;
import com.project.project.user.User;
import lombok.SneakyThrows;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Socket;


@RequestMapping("/send")
@RestController
@Service
public class RabbitMQSender {

    private String exchange = "rabbitmq.exchange";
    private String routingKey = "rabbitmq.routingkey";
    private String queue = "rabbitmq.queue2";
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Bean
    public Queue queue() {
        return new Queue(queue, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @SneakyThrows
    @GetMapping("/{message}")
    public void send(@PathVariable("message") String message) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findById(authentication.getName()).get();

        SQLTableManager sqlDataBase = new SQLTableManager(jdbcTemplate, "TABLE123");
        sqlDataBase.createTable("messageId INT", "message VARCHAR(100)");





        // TODO: создать класс для удобного пользования базой данных //////////////////////////////////////////////////////////////////////////
//        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS DIALOG_" + user.getUniqueCode() + "2" + "(messageId INT PRIMARY KEY, message VARCHAR(100));");
//        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS DIALOG_" + "2" + user.getUniqueCode() + "(messageId INT PRIMARY KEY, message VARCHAR(100));");
//        jdbcTemplate.execute("INSERT DIALOG_" + user.getUniqueCode() + "2" + "(messageId, message) VALUES(2, '" + message + "');");
//        jdbcTemplate.execute("INSERT DIALOG_" + "2" + user.getUniqueCode() + "(messageId, message) VALUES(2, '" + message + "');");
        // TODO//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}