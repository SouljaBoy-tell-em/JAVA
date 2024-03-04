package com.example.application.views;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.PermitAll;


@Route("")
@PermitAll
@AnonymousAllowed
public class TodoView extends VerticalLayout {


    public TodoView() {
        Button SendButton = new Button();
        SendButton.setText("SEND");
        SendButton.addClickListener(listener -> {
            Notification.show("Hello !");
        });
        add(SendButton);
    }
}
