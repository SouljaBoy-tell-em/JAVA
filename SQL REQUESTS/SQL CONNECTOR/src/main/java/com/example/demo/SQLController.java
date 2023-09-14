package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
@RequestMapping
public class SQLController {

    @Autowired
    private SQLRepository sqlRepository;
    private static Connection connection;
    public SQLController() throws SQLException {

//        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "1543");
//        Statement statement = connection.createStatement();
//        statement.execute("UPDATE students SET name='" + "SSS" +"' WHERE id=53");
    }

    @GetMapping("/objects")
    public String AddSQLConnectorObject() {

        sqlRepository.save(new SQLConnectorObject(228, "228"));
        return "page";
    }
}
