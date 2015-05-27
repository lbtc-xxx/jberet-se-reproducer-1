package org.nailedtothex.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabaseUtil {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:h2:./target/mydb");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
