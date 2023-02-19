package com.example.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

@Component
public class DBConnectionManager {
    @Value("${JDBC_DRIVER}")
    private String JDBC_DRIVER;

    @Value("${DB_URL}")
    private String DB_URL;

    @Value("${DB_USER}")
    private String DB_USER;

    @Value("${DB_PASS}")
    private String DB_PASS;


    public Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(connection == null){
            throw new RuntimeException("Failed to make connection!");
        }
        return connection;
    }
}