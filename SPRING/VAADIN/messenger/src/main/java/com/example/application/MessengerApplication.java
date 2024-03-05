package com.example.application;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Push
@SpringBootApplication
@Theme(value = "todo")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class MessengerApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(MessengerApplication.class, args);
    }
}
