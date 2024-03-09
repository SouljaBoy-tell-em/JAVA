package com.example.application.views;


import com.example.application.User;
import com.example.application.configs.ServiceConfig;
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


@PermitAll
@Route("messenger")
@Slf4j
public class MessageView extends Div {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserRepository userRepository;
    private String exchange = "rabbitmq.exchange2";
    private String routingKey = "rabbitmq.routingkey2";
    private String queue = "rabbitmq.queue2";

    // VIEW PARAMETERS:
    private ServiceConfig SERVICE_CONFIG = new ServiceConfig();
    private String currentMessage = "";
    private User currentUser;
    private boolean isScrollerUpdate = false;
    private double messageInputHeight;
    private double windowHeight;

    // PAGE ELEMENTS:
    private Image logoImage;
    private MessageInput messageInput;
    private VerticalLayout messageInputLayout;
    private MessageList messageList;
    private VerticalLayout messageListLayout;
    private Scroller messageListScroller;
    private Tabs pageTabs;
        private Tab messagesTab;
        private Tab userTab;
    private Icon scrollToBottomIcon;
    private UI ui;


    public MessageView() {
        setSizeFull();
        ElemPageInitializer();
        ElemPageDesigner();

        messageInput.addSubmitListener(listener -> {
            isScrollerUpdate = UpdateMessageInput(listener);
        });

        add(
                pageTabs,
                messageListLayout,
                messageInputLayout
        );

        Delay().subscribe(delay -> {
            ui.access(() -> {

                if(isScrollerUpdate) {
                    messageListScroller
                            .getElement()
                            .executeJs(
                                        SERVICE_CONFIG.ScrollToBottomJS()
                                      );
                    isScrollerUpdate = false;
                }

                DynamicParamsInitializer();
                MessageListUpdater();
                messageListScroller
                        .getElement()
                        .executeJs(
                                    SERVICE_CONFIG
                                            .GetHeightDifferenceScrollerJS(),
                                    messageListScroller.getElement()
                                   )
                        .then(height -> {
                            double heightScroller = height.asNumber();
                            scrollToBottomIcon
                                    .setVisible(Math.abs(heightScroller) > 2);
                });
            });
        });

        DynamicElementCreator();
    }

    @Bean
    public Binding Binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(routingKey);
    }


    private Flux<Long> Delay() {
        return Flux
                .interval(Duration
                        .ofMillis(SERVICE_CONFIG.DURATION_100_MS));
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
            messageListScroller
                    .getElement()
                    .executeJs(SERVICE_CONFIG
                            .ScrollToBottomJS());
            scrollToBottomIcon.setVisible(false);
        });
    }

    private void DynamicParamsInitializer() {
        messageInput
                .getElement()
                .executeJs(
                            SERVICE_CONFIG.GetHeightLayoutJS(),
                            messageInput.getElement()
                           )
                .then(height -> {
                    this.messageInputHeight = height.asNumber();
                });
    }

    private void ElemPageDesigner() {
        logoImage.addClassNames(SERVICE_CONFIG.CSS_LOGO_IMAGE);
        messageInput.addClassNames(SERVICE_CONFIG.CSS_MESSAGE_INPUT);
        messageInputLayout.addClassNames(SERVICE_CONFIG
                                        .CSS_MESSAGE_INPUT_LAYOUT);
        messageList.addClassNames(SERVICE_CONFIG.CSS_MESSAGE_LIST);
        messageListLayout.addClassNames(SERVICE_CONFIG
                                       .CSS_MESSAGE_LIST_LAYER);
        messageListScroller.addClassNames(SERVICE_CONFIG
                                         .CSS_MESSAGE_LIST_SCROLLER);
        pageTabs.addClassNames(SERVICE_CONFIG.CSS_PAGE_TABS);
        scrollToBottomIcon.addClassNames(SERVICE_CONFIG
                                        .CSS_SCROLL_TO_BOTTOM_ICON);

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
        logoImage           = new Image(SERVICE_CONFIG.LOGO_LINK, null);

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

    private boolean UpdateMessageInput(MessageInput.SubmitEvent listener) {
        int beforeSize = messageList.getItems().size();
        MessageInputSender(listener);
        int currentSize = messageList.getItems().size();
        return currentSize - beforeSize > 0;
    }
}