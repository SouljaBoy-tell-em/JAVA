package com.example.application.views;


import com.example.application.configs.ServiceConfig;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@AnonymousAllowed
@Route("login")
public class LoginView extends VerticalLayout {

    // CONFIGURATION ELEMENTS:
    private ServiceConfig SERVICE_CONFIG = new ServiceConfig();

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
        logoImage = new Image(SERVICE_CONFIG.LOGO_LINK, null);
        loginForm = new LoginForm();
    }
}
