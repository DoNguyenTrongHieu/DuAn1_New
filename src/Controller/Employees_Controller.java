package Controller;

import DAO_Enity.Entity_Employees;
import JDBC_Controller.Connected_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<Entity_Employees> table;
    @FXML
    private TableColumn<Entity_Employees, String> maNVColumn;
    @FXML
    private TableColumn<Entity_Employees, String> tenNVColumn;
    @FXML
    private TableColumn<Entity_Employees, String> ngaysinhColumn;
    @FXML
    private TableColumn<Entity_Employees, String> gioiTinhColumn;
    @FXML
    private TableColumn<Entity_Employees, String> maChamCongColumn;
    @FXML
    private TableColumn<Entity_Employees, String> maChucVuColumn;
    @FXML
    private TableColumn<Entity_Employees, String> emailColumn;
    @FXML
    private TableColumn<Entity_Employees, String> sdtColumn;

    ObservableList<Entity_Employees> listM = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellTable();
    }
    public void setCellTable(){
        maNVColumn.setCellValueFactory(new PropertyValueFactory<Entity_Employees, String>("maN"));
        tenNVColumn.setCellValueFactory(new PropertyValueFactory<Entity_Employees, String>("tenNV"));
        ngaysinhColumn.setCellValueFactory(new PropertyValueFactory<Entity_Employees, String>("ngaysinh"));
        gioiTinhColumn.setCellValueFactory(new PropertyValueFactory<Entity_Employees, String>("gioitinh"));
        maChamCongColumn.setCellValueFactory(new PropertyValueFactory<Entity_Employees, String>("machamcong"));
        maChucVuColumn.setCellValueFactory(new PropertyValueFactory<Entity_Employees, String>("machucvu"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Entity_Employees, String>("email"));
        sdtColumn.setCellValueFactory(new PropertyValueFactory<Entity_Employees, String>("sdt"));
        table.setItems(listM);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();
            String sql = "select * from NhanVien";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                listM.add(new Entity_Employees(
                        rs.getString("maNV"),
                        rs.getString("tenNV"),
                        rs.getString("ngaysinh"),
                        rs.getString("gioitinh"),
                        rs.getString("machamcong"),
                        rs.getString("machucvu"),
                        rs.getString("email"),
                        rs.getString("sdt")));
            }
            table.setItems(listM);
        } catch (Exception e) {
        }
    }
}
