package JDBC_Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connected_Controller {
    public Connection connectionLink;


    public Connection getConnection(){
        String serverName = "HIEUDO";
        String databaseName = "QuanLyTiemBanh";
        String databaseUsername = "sa";
        String databasePassword = "1234";
        String url = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true";

        try {
            connectionLink = DriverManager.getConnection(url,databaseUsername,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connectionLink;
    }
}
