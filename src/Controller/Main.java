package Controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
//    double x,y = 0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../FXML_File/Employees.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Css/Login.css").toExternalForm());
        primaryStage.initStyle(StageStyle.DECORATED.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
