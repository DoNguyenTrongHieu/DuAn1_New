package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Customer_Controller {
    @FXML
    Button btnExit;
    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }
}
