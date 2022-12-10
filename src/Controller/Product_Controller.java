package Controller;


import DAO_Enity.Customer_DAO;
import DAO_Enity.product_DAO;
import JDBC_Controller.Connected_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Product_Controller implements Initializable {
//    private Connection con = null;
//    private PreparedStatement prstm = null;
//    private ResultSet rs = null;

    @FXML
    Button btnExit;
    @FXML
    JLabel lblThongBao;
    @FXML
    TextField txtid,txtname,txtday,txtdat,txtslot,txtcost ;
    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private TableView<product_DAO> tblModel;

    @FXML
    private TableColumn<product_DAO, String> ProductID;

    @FXML
    private TableColumn<product_DAO, String> Productname;

    @FXML
    private TableColumn<product_DAO, String> Importdate;

    @FXML
    private TableColumn<product_DAO, String> Expirationdate;

    @FXML
    private TableColumn<product_DAO, Integer> Amount;

    @FXML
    private TableColumn<product_DAO, Float> Unitprice;

    ObservableList<product_DAO> list = FXCollections.observableArrayList(
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // hiển thị dự liệu lên table
        fillproduct();
        // loadTable();

    }
    public void fillproduct() {
        ProductID.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("MaSanPham"));
        Productname.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("TenSanPham"));
        Importdate.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("NgayNhapHang"));
        Expirationdate.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("NgayHetHan"));
        Amount.setCellValueFactory(new PropertyValueFactory<product_DAO,Integer>("SoLuong"));
        Unitprice.setCellValueFactory(new PropertyValueFactory<product_DAO,Float>("dongia"));
        tblModel.setItems(list);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String sql = "SELECT MaSanPham,TenSanPham,NgayNhapHang,NgayHetHan,SoLuong,Dongia FROM SanPham where isDeleted=2 ";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new product_DAO(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("NgayNhapHang"),
                        rs.getString("NgayHetHan"),
                        rs.getInt(String.valueOf("SoLuong")),
                        rs.getFloat("dongia")));
            }
            tblModel.setItems(list);
        } catch (Exception e) {

        }
    }
    public void insertValueproduct() {
        if(validate() == true){
            String sql = "INSERT INTO SanPham VALUES ('" + txtid.getText() + "','" + txtname.getText() + "','" + txtday.getText() + "','"  + txtdat.getText() +"','" + txtslot.getText() +"','" + txtcost.getText() +"'"+ "2)";
            executeQuery(sql);
            System.out.println("them thanh cong");
            list.clear();
            try {
                Connected_Controller connected_controller = new Connected_Controller();
                Connection connection1 = connected_controller.getConnection();

                String query = "SELECT MaSanPham,TenSanPham,NgayNhapHang,NgayHetHan,SoLuong,Dongia FROM SanPham where isDeleted=2  ";
                Statement statement = connection1.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    list.add(new product_DAO(
                            rs.getString("MaSanPham"),
                            rs.getString("TenSanPham"),
                            rs.getString("NgayNhapHang"),
                            rs.getString("NgayHetHan"),
                            rs.getInt(String.valueOf("SoLuong")),
                            rs.getFloat("dongia")));
                }
                tblModel.setItems(list);
                lblThongBao.setText("Tạo thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            lblThongBao.setText("Tạo thất bại");
        }

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
    public boolean validate(){
        if(txtid.getText().trim().equalsIgnoreCase("")){
            lblThongBao.setText("Không được bỏ trống ID sản phẩm ");
            return false;
        }
        if(txtname.getText().trim().equalsIgnoreCase("")){
            lblThongBao.setText("Không được bỏ trống tên sản phẩm");
            return false;
        }

        return true;
    }
    public void deleteData() {
        String sql = "UPDATE SanPham SET isDeleted = 3 where MaSanPham = '" + txtid.getText() + "'";
        executeQuery(sql);
        lblThongBao.setText("Xóa thành công");
        list.clear();
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection = connected_controller.getConnection();

            String query = "SELECT MaSanPham,TenSanPham,NgayNhapHang,NgayHetHan,SoLuong,Dongia FROM SanPham where isDeleted=2 ";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                list.add(new product_DAO(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("NgayNhapHang"),
                        rs.getString("NgayHetHan"),
                        rs.getInt(String.valueOf("SoLuong")),
                        rs.getFloat("dongia")));
            }
            tblModel.setItems(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}