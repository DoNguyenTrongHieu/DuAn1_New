package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu_Controller implements Initializable {
    Parent root;
    Scene scene;
    Stage stage;

    @FXML
    BorderPane mainContain;

    @FXML
    public void handleButtonActionOrder(ActionEvent event){
        FXML_Loader ob = new FXML_Loader();
        Pane view = ob.getPage("Order");
        mainContain.setCenter(view);
    }

    @FXML
    public void handleButtonActionCustomer(ActionEvent event){
        FXML_Loader ob = new FXML_Loader();
        Pane view = ob.getPage("Customer");
        mainContain.setCenter(view);
    }
    @FXML
    public void handleButtonActionAttendance(ActionEvent event){
        FXML_Loader ob = new FXML_Loader();
        Pane view = ob.getPage("Attendance");
        mainContain.setCenter(view);
    }
    @FXML
    public void handleButtonActionProduct(ActionEvent event){
        FXML_Loader ob = new FXML_Loader();
        Pane view = ob.getPage("Product");
        mainContain.setCenter(view);
    }
    @FXML
    public void handleButtonEctionemployees(ActionEvent event){
        FXML_Loader ob = new FXML_Loader();
        Pane view = ob.getPage("Employees");
        mainContain.setCenter(view);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
