package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Controller
@RequestMapping
public class SQLController {
    private final static String REGISTER_USER_PAGE = "/register_user";
    private final static String SQLOBJECTS_PAGE = "/sqlbase_users";
    @Autowired
    private SQLRepository sqlRepository;
    @ModelAttribute("SQLConnectorObject")
    public SQLConnectorObject sqlConnectorObject() {
        return new SQLConnectorObject();
    }

    @GetMapping(REGISTER_USER_PAGE)
    public String RegisterUser(@ModelAttribute("SQLConnectorObject") SQLConnectorObject sqlConnectorObject) {
        return "register_user";
    }
    @PostMapping(REGISTER_USER_PAGE)
    public String RegisterUserRedirect(@ModelAttribute("SQLConnectorObject") SQLConnectorObject sqlConnectorObject) {
        return "redirect:/register_user/SQLObjectsBase";
    }

    @PostMapping(REGISTER_USER_PAGE + SQLOBJECTS_PAGE)
    public String SQLObjectsBase(@ModelAttribute("SQLConnectorObject") SQLConnectorObject sqlConnectorObject, Model model) {

        SQLDB sqldb = new SQLDB(sqlRepository.findAll());
        sqlRepository.save(sqlConnectorObject);
        model.addAttribute("SQLDB", sqldb);

        return "SQLObjectsBase";
    }
}
