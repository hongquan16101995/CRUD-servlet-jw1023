package com.example.demo2.DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    private static Connection connection;
    private static String URL = "jdbc:mysql://localhost:3306/product";
    private static String username = "root";
    private static String password = "123456";

    public static Connection getInstance() {
        if (connection == null) {
            connection = getConnection();
        }
        return connection;
    }

    private static Connection getConnection() {
        Connection connection1 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection1 = DriverManager.getConnection(URL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection1;
    }
}
