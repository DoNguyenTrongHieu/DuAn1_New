package JDBC_Controller;

import java.sql.*;

public class Connected_Controller {
    private static Connection connectionLink;


    public static Connection getConnection() {
        String serverName = "KHOALE\\SQLEXPRESS";
        String databaseName = "QuanLyTiemBanh";
        String databaseUsername = "wibu";
        String databasePassword = "123456";
        String url = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true";

        try {
            connectionLink = DriverManager.getConnection(url, databaseUsername, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connectionLink;
    }

}