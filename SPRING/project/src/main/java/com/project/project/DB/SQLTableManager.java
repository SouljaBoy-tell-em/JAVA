package com.project.project.DB;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.*;


@Slf4j
public class SQLTableManager {
    private JdbcTemplate jdbcTemplate;
    private String tableName;

    public SQLTableManager(JdbcTemplate jdbcTemplate, String tableName) throws SQLException {

        this.jdbcTemplate = jdbcTemplate;
        this.tableName = tableName;

//        ResultSet set = this.statement.executeQuery("select count(*) from DIALOG_21");
//        set.next();
//        System.out.println("SET: " + set.getInt(1));
    }

    public void createTable(String ...params) {
        String QUERY = "CREATE TABLE IF NOT EXISTS " + tableName + "(";
        for(int index = 0; index < params.length - 1; index++)
            QUERY += params[index] + ", ";
        QUERY += params[params.length - 1] + ");";
        jdbcTemplate.execute(QUERY);
    }
}
