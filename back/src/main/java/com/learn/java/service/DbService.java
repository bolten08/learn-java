package com.learn.java.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class DbService {
    private static Connection connection;

    public void connect(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
//        statement = connection.createStatement();
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) { /*can't do anything */ }
//        try {
//            statement.close();
//        } catch (SQLException e) { /*can't do anything */ }
        //            try { rs.close(); } catch(SQLException e) { /*can't do anything */ }

    }

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() throws SQLException {
        return connection.createStatement();
    }
}
