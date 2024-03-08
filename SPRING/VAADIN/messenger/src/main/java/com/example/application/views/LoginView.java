package com.example.application.views;


import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@Route("login")
@AnonymousAllowed
public class LoginView extends VerticalLayout {

    private String LOGO_LINK = "https://firebasestorage.googleapis.com/v0/b/spring-base-238608.appspot.com/o/logo.png?alt=media&token=427f1442-8caf-481c-9e5a-4df319d9d0fb";

    // PAGE ELEMENTS:
    private Image logoImage;
    private LoginForm loginForm;

    public LoginView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        ElemPageInitializer();
        ElemPageDesigner();

        add(
                logoImage,
                loginForm
        );
    }

    private void ElemPageDesigner() {
        logoImage.setHeight("150px");
        loginForm.setAction("login");
    }

    private void ElemPageInitializer() {
        logoImage = new Image(LOGO_LINK, null);
        loginForm = new LoginForm();
    }
}
