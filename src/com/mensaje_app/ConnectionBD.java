package com.mensaje_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {

    public Connection get_connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje_app", "root", "");
            // if(connection != null){
            //   System.out.println("Conexion exitosa");
            //}
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

}