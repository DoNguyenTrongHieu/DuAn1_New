package Controller;

import DAO_Enity.Customer_DAO;
import JDBC_Controller.Connected_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Customer_Controller implements Initializable {
//    private Connection con = null;
//    private PreparedStatement prstm = null;
//    private ResultSet rs = null;


    @FXML
    Button btnExit;

    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML
    private TableView<Customer_DAO> tblModel;

    @FXML
    private TableColumn<Customer_DAO, String> billCode;

    @FXML
    private TableColumn<Customer_DAO, String> customerID;

    @FXML
    private TableColumn<Customer_DAO, String> customerName;

    @FXML
    private TableColumn<Customer_DAO, String> phoneNumber;

    @FXML
    private TableColumn<Customer_DAO, Integer> purchasesTime;

    @FXML
    private TableColumn<Customer_DAO, String> staffID;

    @FXML
    private TableColumn<Customer_DAO, Float> totalExpenditure;

    ObservableList<Customer_DAO> list = FXCollections.observableArrayList(
//            new Customer_DAO("1234","Hieu","2345","2223","0000000202", 100.000F,1)
    );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerID.setCellValueFactory(new PropertyValueFactory<Customer_DAO,String>("maKhachHang"));
        customerName.setCellValueFactory(new PropertyValueFactory<Customer_DAO,String>("tenKhachHang"));
        staffID.setCellValueFactory(new PropertyValueFactory<Customer_DAO,String>("maNhanVienHoTro"));
        billCode.setCellValueFactory(new PropertyValueFactory<Customer_DAO,String>("maHoaDon"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Customer_DAO,String>("soDienThoai"));
        totalExpenditure.setCellValueFactory(new PropertyValueFactory<Customer_DAO,Float>("tongTienDaChi"));
        purchasesTime.setCellValueFactory(new PropertyValueFactory<Customer_DAO,Integer>("soLanMuaHang"));

        tblModel.setItems(list);
        try{
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String sql = "SELECT MaKhachHang,TenKhachHang,MaNhanVienHoTro,MaHoaDon,SoDienThoai,TongTienDaChi,SoLanMuaHang FROM KhachHang where isDeleted=1 ";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                list.add(new Customer_DAO(
                        rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getString("MaNhanVienHoTro"),
                        rs.getString("MaHoaDon"),
                        rs.getString("SoDienThoai"),
                        rs.getFloat(String.valueOf("TongTienDaChi")),
                        rs.getInt("SoLanMuaHang")));
            }
            tblModel.setItems(list);
        }catch (Exception e){

        }
    }
}
