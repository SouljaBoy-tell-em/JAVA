package com.example.application.views;


import com.example.application.User;
import com.example.application.repositories.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


@Route("register")
@PermitAll
@AnonymousAllowed
public class RegisterView extends Div {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // PAGE ELEMENTS:
    private VerticalLayout registerVerticalLayout;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField usernameField;
    private TextField emailField;
    private PasswordField passwordField;
    private H1 titleRegistration;
    private Button registerButton;

    public RegisterView() {
        ElemPageInitializer();

        registerButton.addClickListener(click -> {
            userRepository.save(new User(
                    firstNameField.getValue(),
                    lastNameField.getValue(),
                    usernameField.getValue(),
                    emailField.getValue(),
                    passwordEncoder.encode(passwordField.getValue())));
        });

        registerVerticalLayout.add(
                titleRegistration,
                firstNameField,
                lastNameField,
                usernameField,
                emailField,
                passwordField,
                registerButton
        );

        registerVerticalLayout.setSizeFull();
        registerVerticalLayout.setAlignItems(FlexComponent
                                       .Alignment.CENTER);
        registerVerticalLayout.setJustifyContentMode(FlexComponent
                                      .JustifyContentMode.CENTER);
        add(registerVerticalLayout);
    }

    private void ElemPageInitializer() {
        registerVerticalLayout = new VerticalLayout();
        firstNameField    = new TextField("First name");
        lastNameField     = new TextField("Last name");
        usernameField     = new TextField("Username");
        emailField        = new TextField("Email");
        passwordField     = new PasswordField("Password");
        titleRegistration = new H1("Registration:");
        registerButton    = new Button("REGISTER",
                event -> UI.getCurrent().navigate(""));
    }
}
