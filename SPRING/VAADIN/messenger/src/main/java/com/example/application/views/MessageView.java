package com.example.application.views;


import com.example.application.User;
import com.example.application.repositories.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.charts.model.Bottom;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Route("messenger")
@AnonymousAllowed
public class MessageView extends VerticalLayout {

    private String exchange = "rabbitmq.exchange";
    private String routingKey = "rabbitmq.routingkey";
    private String queue = "rabbitmq.queue2";
    private String CurrentMessage = "";
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserRepository userRepository;
    private User CurrentUser;

    public MessageView() {

        MessageList messageList = new MessageList();
        MessageInput messageInput = new MessageInput();
        messageInput.addSubmitListener(listener -> {

            String message = listener.getValue();
            MessageListItem item = new MessageListItem(message,
                                                 Instant.now(),
                                    CurrentUser.getUsername());
            List<MessageListItem> currentUserList =
                   new ArrayList<>(messageList.getItems());
             rabbitTemplate.convertAndSend(exchange, routingKey, message);
             currentUserList.add(item);
             messageList.setItems(currentUserList);
        });

         messageInput.setWidthFull();
         add(messageList, messageInput);

         var ui = UI.getCurrent();
         Delay().subscribe(delay -> {
             ui.access(() -> {

                 CurrentUser = userRepository
                         .findById(GetCurrentUserId())
                         .get();

                 if(CurrentMessage.length() > 0) {
                     MessageListItem item = new MessageListItem(CurrentMessage,
                                                                 Instant.now(),
                                                            "b");
                     List<MessageListItem> list =
                             new ArrayList<>(messageList.getItems());
                     list.add(item);
                     messageList.setItems(list);
                     CurrentMessage = "";
                  }
             });
         });
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

    @RabbitListener(queues = "rabbitmq.queue1")
    public void receive(String message) {
        this.CurrentMessage = message;
    }

    private Flux<Long> Delay() {
        return Flux.interval(Duration.ofMillis(100));
    }

    private String GetCurrentUserId() {

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if(authentication == null)
            throw new NullPointerException();
        return authentication.getName();
    }
}
