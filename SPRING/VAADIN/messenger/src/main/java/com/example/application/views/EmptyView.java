package com.example.application.views;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Select;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.Theme;


@Route("empty")
@AnonymousAllowed
public class EmptyView extends VerticalLayout {

    public EmptyView() {

        setAlignItems(Alignment.CENTER);
        Button specialButton = new Button("I'm special");
        specialButton.addClassNames("special");
        add(specialButton);
    }
}