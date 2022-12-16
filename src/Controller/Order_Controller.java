package Controller;



import DAO_Enity.product_DAO;
import JDBC_Controller.Connected_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Order_Controller implements Initializable {
    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    AnchorPane acPane;
    @FXML
    Button btnde;
    @FXML
    TextField txtid;

    @FXML
    private TableColumn<product_DAO, String> Productname;
    @FXML
    private TableColumn<product_DAO, Float> Unitprice;
    @FXML
    private TableColumn<product_DAO, Integer> slot;
    @FXML
    private TableView<product_DAO> tblModel;
    ObservableList<product_DAO> list = FXCollections.observableArrayList(
    );
    @FXML
    public void handleButtonActionPay(ActionEvent event) throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../FXML_File/Pay.fxml"));
        acPane.getChildren().setAll(anchorPane);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // hiển thị dự liệu lên table
        fillproduct();


    }
    public void fillproduct() {
        Productname.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("TenSanPham"));
        Unitprice.setCellValueFactory(new PropertyValueFactory<product_DAO,Float>("dongia"));
        slot.setCellValueFactory(new PropertyValueFactory<product_DAO,Integer>("SoLuong"));
        tblModel.setItems(list);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();
            String sql = "SELECT TENSANPHAM,DONGIA FROM SANPHAM WHERE ISDELETED=2";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new product_DAO(
                        rs.getString("TenSanPham"),
                        rs.getFloat("dongia")));

            }
            tblModel.setItems(list);
        } catch (Exception e) {

        }
    }
    // fill dữ liệu được chọn lên textfield
    public void selectedID(){
        product_DAO product_DAO = tblModel.getSelectionModel().getSelectedItem();
        txtid.setText(String.valueOf(product_DAO.getSoLuong()));
    }
    public void executeQuery(String query) {
        Connected_Controller connected_controller = new Connected_Controller();
        Connection con = connected_controller.getConnection();
        Statement statement;
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void executeUpdate(){
        String sql = "update SanPham set MaSanPham = '"+ txtid.getText()+"' ,SoLuong='";
        executeQuery(sql);
        list.clear();
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String query = "SELECT TENSANPHAM,DONGIA,SOLUONG FROM SANPHAM WHERE ISDELETED=2";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                list.add(new product_DAO(
                        rs.getString("TenSanPham"),
                        rs.getInt(String.valueOf("SoLuong")),
                        rs.getFloat("dongia")));
            }
            tblModel.setItems(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


