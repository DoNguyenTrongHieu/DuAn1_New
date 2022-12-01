package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Order_Controller {
    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML
    AnchorPane acPane;
    @FXML
    public void handleButtonActionPay(ActionEvent event) throws Exception{
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../FXML_File/Pay.fxml"));
        acPane.getChildren().setAll(anchorPane);
    }

}
