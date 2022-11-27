package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FXML_Loader {
    private Pane view;
    public Pane getPage(String fileName){
        try {
            URL fileUrl = Menu_Controller.class.getResource("../FXML_File/"+fileName+".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("tim ko thay nha ong gia");
            }
            view = new FXMLLoader().load(fileUrl);
        }catch (Exception e){
            System.out.println("No page");
        }
        return view;
    }

}
