package Controller;

import JDBC_Controller.Connected_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Login_Controller{
    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }
    @FXML
    TextField txtUser;
    @FXML
    PasswordField txtPassword;
    @FXML
    Button btnLogin;
    @FXML
    Label lblThongBao;

    Parent root = null;
    Scene scene = null;
    Stage stage = null;


    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if(txtUser.getText().isBlank() == false && txtPassword.getText().isBlank() == false){
            if(validateLogin() == true){
                root = (Parent) FXMLLoader.load(this.getClass().getResource("../FXML_File/MainMenu.fxml"));
                scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("../Css/MainMenu.css").toExternalForm());
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(this.scene);
                stage.centerOnScreen();
                stage.setResizable(false);
//                stage.setFullScreen(true);
                stage.show();
            }
        }
    }

    public boolean validateLogin(){
        Connected_Controller connectedNow = new Connected_Controller();
        Connection connectionDB = connectedNow.getConnection();

        String sql = "SELECT COUNT(*) FROM CHUCVU WHERE TAIKHOAN='"+txtUser.getText()+"' and MATKHAU='"+txtPassword.getText()+"'";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if (resultSet.getInt(1) >= 1) {
                    return true;
                }else{
                    lblThongBao.setText("That bai");
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



}
