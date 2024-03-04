package com.example.application.views;


import com.example.application.User;
import com.example.application.repositories.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
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

    public RegisterView() {

        TextField FirstNameField = new TextField("First name");
        TextField LastNameField  = new TextField("Last name");
        TextField UsernameField  = new TextField("Username");
        TextField EmailField     = new TextField("Email");
        PasswordField Password   = new PasswordField("Password");
        H1 TitleRegistration     = new H1("Registration:");
        Button RegisterButton    = new Button("REGISTER", event -> UI.getCurrent().navigate(""));

        RegisterButton.addClickListener(click -> {
            userRepository.save(new User(
                    FirstNameField.getValue(),
                    LastNameField.getValue(),
                    UsernameField.getValue(),
                    EmailField.getValue(),
                    passwordEncoder.encode(Password.getValue())));
        });

        VerticalLayout RegisterVerticalLayout = new VerticalLayout();
        RegisterVerticalLayout.add(
                TitleRegistration,
                FirstNameField,
                LastNameField,
                UsernameField,
                EmailField,
                Password,
                RegisterButton
        );

        RegisterVerticalLayout.setSizeFull();
        RegisterVerticalLayout.setAlignItems(FlexComponent
                                       .Alignment.CENTER);
        RegisterVerticalLayout.setJustifyContentMode(FlexComponent
                                      .JustifyContentMode.CENTER);
        add(RegisterVerticalLayout);
    }
}
