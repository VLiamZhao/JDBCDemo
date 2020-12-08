package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/DatabaseName";


    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.err.println(e);
        }
        return conn;
    }
}
