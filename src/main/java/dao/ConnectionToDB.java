package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/citilink_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234567890";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
