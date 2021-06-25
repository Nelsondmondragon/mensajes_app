package com.mensaje_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    public static Connection connection;

    public static Connection get_connection() {
        connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje_app", "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

}
