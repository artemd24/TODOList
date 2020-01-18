package ru.ifmo.OOP.dal;

import java.sql.*;

public class ConnectionPool {

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:TASKLIST.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}