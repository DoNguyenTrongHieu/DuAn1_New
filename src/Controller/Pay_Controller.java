package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Pay_Controller {
    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML
    AnchorPane anchorPane;

    @FXML
    public void backToOrder(ActionEvent event) throws Exception{
        AnchorPane anchoraPane = FXMLLoader.load(getClass().getResource("../FXML_File/Order.fxml"));
        anchorPane.getChildren().setAll(anchoraPane);
    }
}
