package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Security_Controller implements Initializable {

    @FXML
    TextField txtPin;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    Parent root = null;
    Scene scene = null;
    Stage stage = null;

    @FXML
    public void backButton(ActionEvent event) throws Exception{
        root = (Parent) FXMLLoader.load(this.getClass().getResource("../FXML_File/MainMenu.fxml"));
        scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("../Css/MainMenu.css").toExternalForm());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(this.scene);
        stage.centerOnScreen();
        stage.setResizable(false);
//                stage.setFullScreen(true);
        stage.show();
    }
    public boolean validateApplyAndNext(){
        if(txtPin.getText().equalsIgnoreCase("0000")){
            return true;
        }else{
            return false;
        }
    }
    public void applyAndNext(ActionEvent event) throws Exception{
        if(validateApplyAndNext() == true){
            root = (Parent) FXMLLoader.load(this.getClass().getResource("../FXML_File/Change_Salary.fxml"));
            scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("../Css/MainMenu.css").toExternalForm());
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(this.scene);
            stage.centerOnScreen();
            stage.setResizable(false);
//                stage.setFullScreen(true);
            stage.show();
        }

    }

}
