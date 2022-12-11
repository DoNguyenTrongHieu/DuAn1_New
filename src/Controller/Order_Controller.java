package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Order_Controller {
    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    AnchorPane acPane;
    @FXML
    Button btnde, btngato, btntira, btnkembap, btnpia, btnmousse, btnchesss, btnflan, btn1k, btnupcake;

    @FXML
    public void handleButtonActionPay(ActionEvent event) throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../FXML_File/Pay.fxml"));
        acPane.getChildren().setAll(anchorPane);
    }
    public void changebutton(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../FXML_File/DeTails.fxml"));
        Parent  view= loader.load();
        Scene sc= new Scene(view);
        Pay_Controller or = loader.getController();

        stage.setScene(sc);
    }

}

