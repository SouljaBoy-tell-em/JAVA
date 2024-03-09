package com.example.application.views;


import com.example.application.User;
import com.example.application.repositories.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Route("messenger")
@PermitAll
@Slf4j
public class MessageView extends Div {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserRepository userRepository;
    public String LOGO_LINK = "https://firebasestorage.googleapis.com/v0/b/spring-base-238608.appspot.com/o/logo.png?alt=media&token=427f1442-8caf-481c-9e5a-4df319d9d0fb";
    private User currentUser;
    private String exchange = "rabbitmq.exchange2";
    private String routingKey = "rabbitmq.routingkey2";
    private String queue = "rabbitmq.queue2";
    private String currentMessage = "";

    // PAGE ELEMENTS:
    private UI ui;
    private Image logoImage;
    private Tabs pageTabs;
            private Tab userTab;
            private Tab messagesTab;
    private VerticalLayout messageListLayout;
    private VerticalLayout messageInputLayout;
    private Scroller messageListScroller;
    private MessageList messageList;
    private MessageInput messageInput;
    private Icon scrollToBottomIcon;
    private float windowHeight;
    private double messageInputHeight;

    int beforeSize = 0;
    int currentSize = 0;

    public MessageView() {
        setSizeFull();
        ElemPageInitializer();
        ElemPageDesigner();


        messageInput.addSubmitListener(listener -> {
            beforeSize = messageList.getItems().size();
            MessageInputSender(listener);
            currentSize = messageList.getItems().size();
        });


        add(
                pageTabs,
                messageListLayout,
                messageInputLayout
        );

        Delay().subscribe(delay -> {
            ui.access(() -> {

                if(currentSize - beforeSize > 0) {
                    messageListScroller.getElement().executeJs(
                            "var el = this; " +
                                    "el.scrollTo(0, el.scrollHeight);");
                    currentSize = beforeSize = 0;
                }

                DynamicParamsInitializer();
                MessageListUpdater();
                messageListScroller.getElement().executeJs("""
                return $0.scrollTop + $0.clientHeight - $0.scrollHeight;
            """, messageListScroller.getElement()).then(height -> {
                    double heightScroller = height.asNumber();
                    if(Math.abs(heightScroller) > 2)
                        scrollToBottomIcon.setVisible(true);
                    else
                        scrollToBottomIcon.setVisible(false);
                });
            });
        });

        DynamicElementCreator();
    }

    @Bean
    public Binding Binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }


    private Flux<Long> Delay() {
        return Flux.interval(Duration.ofMillis(100));
    }

    private void DynamicElementCreator() {

        ui.getPage().retrieveExtendedClientDetails(details -> {
            this.windowHeight = details.getWindowInnerHeight();
            messageListLayout.setHeight((float) (windowHeight -
                            messageInputHeight -
                            25),
                    Unit.PIXELS);
        });
        ui.getPage().addBrowserWindowResizeListener(details -> {
            this.windowHeight = details.getHeight();
            messageListLayout.setHeight((float) (windowHeight -
                            messageInputHeight -
                            25),
                    Unit.PIXELS);
        });

        scrollToBottomIcon.addClickListener(click -> {
            messageListScroller.getElement().executeJs(
                    "var el = this; " +
                            "el.scrollTo(0, el.scrollHeight);");
            scrollToBottomIcon.setVisible(false);
        });
    }

    private void DynamicParamsInitializer() {
        messageInput
                .getElement()
                .executeJs("return $0.clientHeight", messageInput
                        .getElement())
                .then(height -> {
                    this.messageInputHeight = height.asNumber();
                });
    }

    private void ElemPageDesigner() {
        logoImage.addClassNames("logo_image");
        messageInput.addClassNames("message_input");
        messageInputLayout.addClassNames("message_input_layout");
        messageList.addClassNames("message_list");
        messageListLayout.addClassNames("message_list_layer");
        messageListScroller.addClassNames("message_list_scroller");
        pageTabs.addClassNames("page_tabs");
        scrollToBottomIcon.addClassNames("scroll_to_bottom_icon");

        pageTabs.setOrientation(Tabs.Orientation.VERTICAL);

        messageListScroller.setContent(messageList);
        messageListLayout.add(messageListScroller);

        messageInputLayout.add(scrollToBottomIcon);
        messageInputLayout.setAlignSelf(FlexComponent.Alignment.END,
                                                scrollToBottomIcon);
        messageInputLayout.add(messageInput);
        messageListLayout.setAlignSelf(FlexComponent.Alignment.END,
                                                     messageInput);
    }

    private void ElemPageInitializer() {
        ui                  = UI.getCurrent();
        logoImage           = new Image(LOGO_LINK, null);

        userTab = new Tab(VaadinIcon.USER.create(),
                         new Span("Profile"));
        messagesTab = new Tab(VaadinIcon.COMMENTS.create(),
                                new Span("Messages"));
        pageTabs            = new Tabs(
                                          userTab,
                                          messagesTab
                                      );

        messageListLayout   = new VerticalLayout();
        messageInputLayout  = new VerticalLayout();
        messageListScroller = new Scroller();
        messageList         = new MessageList();
        messageInput        = new MessageInput();
        scrollToBottomIcon  = VaadinIcon.CHEVRON_CIRCLE_DOWN.create();
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
                currentUser.getUsername());
        List<MessageListItem> currentUserList =
                new ArrayList<>(messageList.getItems());
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        currentUserList.add(item);
        messageList.setItems(currentUserList);
    }

    private void MessageListUpdater() {
        currentUser = userRepository
                .findById(GetCurrentUserId())
                .get();

        if(!currentMessage.isEmpty()) {
            MessageListItem item = new MessageListItem(currentMessage,
                                                        Instant.now(),
                                                       "b");
            List<MessageListItem> list =
                    new ArrayList<>(messageList.getItems());
            list.add(item);
            messageList.setItems(list);
            currentMessage = "";
        }
    }

    @Bean
    public Queue Queue() {
        return new Queue(queue, false);
    }

    @RabbitListener(queues = "rabbitmq.queue1")
    public void Receive(String message) {
        this.currentMessage = message;
    }
}
