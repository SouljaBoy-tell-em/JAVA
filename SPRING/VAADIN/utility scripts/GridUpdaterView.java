package com.example.application.views.main;


import com.example.application.User;
import com.example.application.repositories.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

import javax.sql.DataSource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


@PageTitle("Main")
@Route(value = "")
public class MainView extends VerticalLayout {

    @Autowired
    private UserRepository userRepository;
    private List<User> users;
    private UI ui;

    public MainView(UserRepository userRepository) {
        setSizeFull();
        this.userRepository = userRepository;
        ui = UI.getCurrent();

        FormLayout formLayout = new FormLayout();
        TextField username    = new TextField("Username");
        TextField password    = new TextField("Password");
        Button buttonAdd      = new Button("ADD");
        Button buttonRemove   = new Button("REMOVE");

        formLayout.add(new VerticalLayout(new HorizontalLayout(username, password),
                                          new HorizontalLayout(buttonAdd, buttonRemove)));
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));

        Grid<User> grid = new Grid<>(User.class, false);
        grid.addColumn(User::getUsername).setHeader("Username");
        grid.addColumn(User::getPassword).setHeader("Password");

        users = userRepository.findAll();
        grid.setItems(users);

        buttonAdd.addClickListener(click -> {
            userRepository.save(new User(username.getValue(),
                    password.getValue()));
            users = userRepository.findAll();
            grid.setItems(users);
        });

        buttonRemove.addClickListener(click -> {
            userRepository.deleteById(username.getValue());
            users = userRepository.findAll();
            grid.setItems(users);
        });

        add(formLayout, grid);
    }
}
