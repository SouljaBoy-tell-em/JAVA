package com.example.application.views;


import com.example.application.User;
import com.example.application.configs.ServiceConfig;
import com.example.application.repositories.UserRepository;
import com.vaadin.collaborationengine.CollaborationAvatarGroup;
import com.vaadin.collaborationengine.CollaborationMessageInput;
import com.vaadin.collaborationengine.CollaborationMessageList;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import reactor.core.publisher.Flux;
import java.time.Duration;


@Data
@PermitAll
@Route("messenger")
@Slf4j
public class MessengerView extends Div {

    @Autowired
    private UserRepository userRepository;
    private User user;

    // CONFIGURATION ELEMENTS:
    private double messageInputHeight;
    private double messageInputWidth;
    private ServiceConfig SERVICE_CONFIG = new ServiceConfig();
    private String topicId = "topicId";
    private UserInfo userInfo;
    private double windowHeight;

    // PAGE ELEMENTS:
    private CollaborationAvatarGroup   avatarGroup;
    private VerticalLayout              chatLayout;
    private VerticalLayout         leftBlockLayout;
    private CollaborationMessageInput messageInput;
    private CollaborationMessageList   messageList;
    private UI                                  ui;

        // LOGO BLOCK ELEMENT:
        private Image                    logoImage;
        private H6                        siteName;

        // USER LIST:
        private Scroller           scrollerUserBox;
        private ListBox<User>              userBox;

    public MessengerView(UserRepository userRepository) {
        setSizeFull();
        UserInitializer(userRepository);
        ElemPageInitializer(userRepository);

        add(
                leftBlockLayout,
                ChatLayout()
        );

        DynamicPageInitializer();
        DynamicElementCreator();
    }

    private Component ChatLayout() {
        chatLayout.add(
                messageList,
                messageInput
        );
        chatLayout.expand(messageList);
        chatLayout.setHeightFull();

        return chatLayout;
    }

    private Flux<Long> Delay() {
        return Flux
                .interval(Duration
                        .ofMillis(SERVICE_CONFIG.DURATION_100_MS));
    }

    private void DynamicElementCreator() {
        ui.getPage().retrieveExtendedClientDetails(details -> {
            this.windowHeight = details.getWindowInnerHeight();
            scrollerUserBox.setWidth((float) (details.getWindowInnerWidth() -
                            messageInputWidth -
                            25),
                    Unit.PIXELS);
            messageList.setHeight((float) (windowHeight -
                            messageInputHeight -
                            25),
                    Unit.PIXELS);
            scrollerUserBox.setHeight((float) (windowHeight -
                            messageInputHeight -
                            50),
                    Unit.PIXELS);
        });

        ui.getPage().addBrowserWindowResizeListener(details -> {
            this.windowHeight = details.getHeight();
            scrollerUserBox.setWidth((float) (details.getWidth() -
                            messageInputWidth -
                            25),
                    Unit.PIXELS);
            messageList.setHeight((float) (windowHeight -
                            messageInputHeight -
                            25),
                    Unit.PIXELS);
            scrollerUserBox.setHeight((float) (windowHeight -
                            messageInputHeight -
                            50),
                    Unit.PIXELS);
        });
    }

    private void DynamicPageInitializer() {
        Delay().subscribe(delay -> {
            ui.access(() -> {
                messageInput
                        .getElement()
                        .executeJs(
                                SERVICE_CONFIG.GetHeightLayoutJS(),
                                messageInput.getElement()
                        )
                        .then(height -> {
                            this.messageInputHeight = height.asNumber();
                        });
                messageInput
                        .getElement()
                        .executeJs(
                                SERVICE_CONFIG.GetWidthLayoutJS(),
                                messageInput.getElement()
                        ).then(width -> {
                            this.messageInputWidth = width.asNumber();
                        });
            });
        });
    }

    private void ElemPageInitializer(UserRepository userRepository) {
        avatarGroup     = new CollaborationAvatarGroup(userInfo, topicId);
        chatLayout      = new VerticalLayout();
        leftBlockLayout = new VerticalLayout();
        logoImage       = new Image(SERVICE_CONFIG.LOGO_LINK, null);
        messageList     = new CollaborationMessageList(userInfo, topicId);
        messageInput    = new CollaborationMessageInput(messageList);
        scrollerUserBox = new Scroller();
        siteName        = new H6("HAIR.hub");
        ui              = UI.getCurrent();
        userBox         = new ListBox<>();

        avatarGroup.addClassNames(SERVICE_CONFIG.CSS_AVATAR_GROUP);
        chatLayout.addClassNames(SERVICE_CONFIG.CSS_CHAT_LAYOUT);
        leftBlockLayout.addClassNames(SERVICE_CONFIG.CSS_LOGO_BLOCK_LAYOUT);
        logoImage.addClassNames(SERVICE_CONFIG.CSS_LOGO_IMAGE);
        messageInput.addClassNames(SERVICE_CONFIG.CSS_MESSAGE_INPUT);
        messageList.addClassNames(SERVICE_CONFIG.CSS_MESSAGE_LIST);
        userBox.addClassNames(SERVICE_CONFIG.CSS_USER_BOX);

        userBox.setItems(userRepository.findAll());
        userBox.setRenderer(new ComponentRenderer<>(user -> {
            HorizontalLayout userLayout = new HorizontalLayout();
            userLayout.setAlignItems(FlexComponent.Alignment.CENTER);

            Avatar avatar = new Avatar();
            avatar.setImage(null);

            Span username = new Span(user.getUsername());
            Span firstname = new Span(user.getFirstname());
            firstname.getStyle()
                    .set("color", "var(--lumo-secondary-text-color)")
                    .set("font-size", "var(--lumo-font-size-s)");

            VerticalLayout userInfoColumn
                    = new VerticalLayout(username, firstname);
            userInfoColumn.setPadding(false);
            userInfoColumn.setSpacing(false);

            userLayout.add(avatar, userInfoColumn);
            userInfoColumn.getStyle().set("line-height",
                           "var(--lumo-line-height-m)");

            return userLayout;
        }));

        scrollerUserBox.setContent(userBox);

        HorizontalLayout logoBlockLayout
                = new HorizontalLayout(logoImage, siteName);
        leftBlockLayout.add(logoBlockLayout, scrollerUserBox);
    }

    private void UserInitializer(UserRepository userRepository) {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        user = userRepository
                .findById(authentication.getName())
                .get();
        userInfo = new UserInfo(user.getUsername(),
                user.getFirstname()
        );
    }
}