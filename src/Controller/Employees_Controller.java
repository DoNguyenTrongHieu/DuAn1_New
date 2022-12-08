package Controller;

import DAO_Enity.Employees_DAO;
import JDBC_Controller.Connected_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Employees_Controller implements Initializable {
    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML
    private TextField txtMaNV;
    @FXML
    private TextField txtTenNV;
    @FXML
    private TextField txtNgaySinh;
    @FXML
    private RadioButton rdbNam, rdbNu;
    @FXML
    private TextField txtMaChamCong;
    @FXML
    private TextField txtMaChucVu;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSdt;
    @FXML
    private Button btnThem;
    @FXML
    private Button btnXoa;
    @FXML
    private Button btnSua;
    @FXML
    private Button btnLamMoi;
    @FXML
    private TableView<Employees_DAO> table;
    @FXML
    private TableColumn<Employees_DAO, String> maNVColumn;
    @FXML
    private TableColumn<Employees_DAO, String> tenNVColumn;
    @FXML
    private TableColumn<Employees_DAO, String> ngaysinhColumn;
    @FXML
    private TableColumn<Employees_DAO, Boolean> gioiTinhColumn;
    @FXML
    private TableColumn<Employees_DAO, String> maChamCongColumn;
    @FXML
    private TableColumn<Employees_DAO, String> maChucVuColumn;
    @FXML
    private TableColumn<Employees_DAO, String> emailColumn;
    @FXML
    private TableColumn<Employees_DAO, String> sdtColumn;

    ObservableList<Employees_DAO> listM = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellTable();
    }
    public void setCellTable(){
        maNVColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("maNv"));
        tenNVColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("hoTen"));
        ngaysinhColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("ngaySinh"));
        gioiTinhColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, Boolean>("gioiTinh"));
        maChamCongColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("maChamCong"));
        maChucVuColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("maChucVu"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("email"));
        sdtColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("soDienThoai"));
        table.setItems(listM);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();
            String sql = "select MaNv,HoTen,NgaySinh,GioiTinh,MaChamCong,MaChucVu,Email,SoDienThoai from NhanVien";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                listM.add(new Employees_DAO(
                        rs.getString("maNV"),
                        rs.getString("HoTen"),
                        rs.getString("ngaysinh"),
                        rs.getBoolean("gioitinh"),
                        rs.getString("machamcong"),
                        rs.getString("machucvu"),
                        rs.getString("email"),
                        rs.getString("soDienThoai")));
            }
            table.setItems(listM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    AnchorPane anchorPaneM;
    @FXML
    public void handleButtonActionSalary(ActionEvent event) throws Exception{
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../FXML_File/Salary.fxml"));
        anchorPaneM.getChildren().setAll(anchorPane);
    }
}
