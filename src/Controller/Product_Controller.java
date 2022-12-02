package Controller;


import DAO_Enity.product_DAO;
import JDBC_Controller.Connected_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Product_Controller implements Initializable {
//    private Connection con = null;
//    private PreparedStatement prstm = null;
//    private ResultSet rs = null;

    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private TableView<product_DAO> tblModel;

    @FXML
    private TableColumn<product_DAO, String> billCode;

    @FXML
    private TableColumn<product_DAO, String> ProductID;

    @FXML
    private TableColumn<product_DAO, String> Produictname;

    @FXML
    private TableColumn<product_DAO, String> Importdate;

    @FXML
    private TableColumn<product_DAO, String> Expirationdate;

    @FXML
    private TableColumn<product_DAO, String> Amount;

    @FXML
    private TableColumn<product_DAO, Float> Unitprice;

    ObservableList<product_DAO> list = FXCollections.observableArrayList(
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProductID.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("MaSamPham"));
        Produictname.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("TenSanpham"));
        Importdate.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("Ngaynhaphang"));
        Expirationdate.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("Ngayhethan"));
        Amount.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("SoLuong"));
        Unitprice.setCellValueFactory(new PropertyValueFactory<product_DAO,Float>("DonGia"));


        tblModel.setItems(list);
        try{
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection = connected_controller.getConnection();

            String sql = "SELECT MaSanPham,TenSanPham,NgayNhapHang,NgayHetHan,SoLuong,DonGia, FROM SanPham where isDeleted=1 ";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                list.add(new product_DAO(
                        rs.getString("MASanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("NgayNhapHang"),
                        rs.getString("NgayHetHan"),
                        rs.getString("SoLuong"),
                        rs.getFloat(String.valueOf("DonGia"))));
            }
            tblModel.setItems(list);
        }catch (Exception e){

        }
    }
}