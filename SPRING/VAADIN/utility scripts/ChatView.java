package com.example.application.views;


import com.example.application.User;
import com.example.application.repositories.UserRepository;
import com.vaadin.collaborationengine.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.PermitAll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@AnonymousAllowed
@PermitAll
@Route("page")
@Slf4j
public class ChatView extends VerticalLayout {

    @Autowired
    private UserRepository userRepository;
    private UserInfo userInfo;


    public ChatView(UserRepository userRepository) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findById(authentication.getName()).get();
        userInfo = new UserInfo(user.getUsername(), user.getFirstname());
        HorizontalLayout mainLayout = new HorizontalLayout(HeaderLayout(), ChatLayout());

        setWidth(null);
        setHeightFull();
        add(
                mainLayout
        );
        expand(
                mainLayout
        );
    }

    private Component HeaderLayout() {
        var header = new HorizontalLayout();
        header.setWidthFull();
        header.setAlignItems(Alignment.BASELINE);

        var avatars = new CollaborationAvatarGroup(userInfo, "users");
        avatars.getStyle().set("width", "unset");
        var title = new H1("List");
        header.add(title, avatars);
        header.expand(title);

        return header;
    }

    private Component ChatLayout() {
        var messageList = new CollaborationMessageList(userInfo, "chat");
        var messageInput = new CollaborationMessageInput(messageList);
        var chatLayout = new VerticalLayout(
                new H2("Chat"),
                messageList,
                messageInput
        );

        chatLayout.setHeightFull();
        chatLayout.setWidth(null);
        chatLayout.expand(messageList);
        return chatLayout;
    }
}
