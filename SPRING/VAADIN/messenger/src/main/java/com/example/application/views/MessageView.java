package com.example.application.views;


import com.example.application.User;
import com.example.application.repositories.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Route("messenger")
@AnonymousAllowed
@Slf4j
//@Lazy
public class MessageView extends Div {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserRepository userRepository;
    private User CurrentUser;
    private String exchange = "rabbitmq.exchange2";
    private String routingKey = "rabbitmq.routingkey2";
    private String queue = "rabbitmq.queue2";
    private String CurrentMessage = "";

    // PAGE ELEMENTS:
    private VerticalLayout middleLayer;
    private Scroller messageListScroller;
    private MessageList messageList;
    private MessageInput messageInput;

    public MessageView() {
        ElemPageInitializer();
        ElemPageDesigner();

        messageInput.addSubmitListener(listener -> {
            MessageInputSender(listener);
        });

        middleLayer.add(messageListScroller);
        add(middleLayer, messageInput);

        var ui = UI.getCurrent();
        Delay().subscribe(delay -> {
            ui.access(() -> {
                MessageListUpdater();
            });
        });
    }

    @Bean
    public Binding Binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }


    private Flux<Long> Delay() {
        return Flux.interval(Duration.ofMillis(100));
    }


    private void ElemPageDesigner() {
        middleLayer.addClassNames("middle_layer");
        messageListScroller.addClassNames("message_list_scroller");
        messageInput.addClassNames("message_input");

        messageListScroller.setContent(messageList);
    }

    private void ElemPageInitializer() {
        middleLayer         = new VerticalLayout();
        messageListScroller = new Scroller();
        messageList         = new MessageList();
        messageInput        = new MessageInput();
    }

    @Bean
    public TopicExchange Exchange() {
        return new TopicExchange(exchange);
    }

    private String GetCurrentUserId() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if(authentication == null) {
            log.error(String
                    .valueOf(Thread
                            .currentThread()
                            .getStackTrace()[2]
                            .getLineNumber()));
            throw new NullPointerException();
        }
        return authentication.getName();
    }

    private void MessageInputSender(MessageInput.SubmitEvent listener) {
        String message = listener.getValue();
        MessageListItem item = new MessageListItem(message,
                Instant.now(),
                CurrentUser.getUsername());
        List<MessageListItem> currentUserList =
                new ArrayList<>(messageList.getItems());
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        currentUserList.add(item);
        messageList.setItems(currentUserList);
    }

    private void MessageListUpdater() {
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
    }

    @Bean
    public Queue Queue() {
        return new Queue(queue, false);
    }

    @RabbitListener(queues = "rabbitmq.queue1")
    public void Receive(String message) {
        this.CurrentMessage = message;
    }
}
