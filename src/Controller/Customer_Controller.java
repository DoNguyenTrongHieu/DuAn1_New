package Controller;

import DAO_Enity.Customer_DAO;
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

public class Customer_Controller implements Initializable {

    @FXML
    Label lblThongBao;

    @FXML
    TextField txtName, txtPhoneNumber, txtStaffID;
    @FXML
    TextField txtMaKhachHang;

    @FXML
    Button btnExit;

    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private TableView<Customer_DAO> tblModel;


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
    // cái này thì chịu chắc là cũng kiểu tạo arraylist để dùng nó chứ data r đưa lên table
    ObservableList<Customer_DAO> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // hiển thị dự liệu lên table
        showListCustomer();
        // loadTable();
    }

    public void showListCustomer() {
        //cái này ko biết để tìm hiểu sau chạy là được
        customerID.setCellValueFactory(new PropertyValueFactory<Customer_DAO, String>("maKhachHang"));
        customerName.setCellValueFactory(new PropertyValueFactory<Customer_DAO, String>("tenKhachHang"));
        staffID.setCellValueFactory(new PropertyValueFactory<Customer_DAO, String>("maNhanVienHoTro"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Customer_DAO, String>("soDienThoai"));
        totalExpenditure.setCellValueFactory(new PropertyValueFactory<Customer_DAO, Float>("tongTienDaChi"));
        purchasesTime.setCellValueFactory(new PropertyValueFactory<Customer_DAO, Integer>("soLanMuaHang"));
        //setItem cho table có tên là tblModel
        tblModel.setItems(list);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String sql = "SELECT MaKhachHang,TenKhachHang,MaNhanVienHoTro,SoDienThoai,TongTienDaChi,SoLanMuaHang FROM KhachHang where isDeleted=2 ";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Customer_DAO(
                        rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getString("MaNhanVienHoTro"),
                        rs.getString("SoDienThoai"),
                        rs.getFloat(String.valueOf("TongTienDaChi")),
                        rs.getInt("SoLanMuaHang")));
            }
            tblModel.setItems(list);
        } catch (Exception e) {

        }
    }

//    public void loadTable() {
//        list.clear();
//        try {
//            Connected_Controller connected_controller = new Connected_Controller();
//            Connection connection1 = connected_controller.getConnection();
//
//            String sql = "SELECT MaKhachHang,TenKhachHang,MaNhanVienHoTro,SoDienThoai,TongTienDaChi,SoLanMuaHang FROM KhachHang where isDeleted=1 ";
//            Statement statement = connection1.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                list.add(new Customer_DAO(
//                        rs.getString("MaKhachHang"),
//                        rs.getString("TenKhachHang"),
//                        rs.getString("MaNhanVienHoTro"),
//                        rs.getString("SoDienThoai"),
//                        rs.getFloat(String.valueOf("TongTienDaChi")),
//                        rs.getInt("SoLanMuaHang")));
//            }
//            tblModel.setItems(list);
//        } catch (Exception e) {
//
//        }
//    }
    // insert data
    public void insertValueCustomer() {
        if(validate() == true){
            String sql = "INSERT INTO KHACHHANG VALUES ('',N'" + txtName.getText() + "','" + txtStaffID.getText().toUpperCase() + "'," + "null,'" + txtPhoneNumber.getText() + "'," + "null," + "null," + "2)";
            executeQuery(sql);
            System.out.println("them thanh cong");
            list.clear();
            try {
                Connected_Controller connected_controller = new Connected_Controller();
                Connection connection1 = connected_controller.getConnection();

                String query = "SELECT MaKhachHang,TenKhachHang,MaNhanVienHoTro,SoDienThoai,TongTienDaChi,SoLanMuaHang FROM KhachHang where isDeleted=2 ";
                Statement statement = connection1.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    list.add(new Customer_DAO(
                            rs.getString("MaKhachHang"),
                            rs.getString("TenKhachHang"),
                            rs.getString("MaNhanVienHoTro"),
                            rs.getString("SoDienThoai"),
                            rs.getFloat(String.valueOf("TongTienDaChi")),
                            rs.getInt("SoLanMuaHang")));
                }
                tblModel.setItems(list);
                lblThongBao.setText("Tạo thành viên thành công");
            } catch (Exception e) {
                lblThongBao.setText("Tạo thành viên thất bại");
            }
        }else{
            lblThongBao.setText("Tạo thành viên thất bại");
        }

    }
    // thực hiện query data
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
    // validate số điện thoại
    public boolean numberValidate(String str){
        return str.matches("(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})\\b");
    }
    //validate dữ liệu nhập vào
    public boolean validate(){
        if(txtName.getText().trim().equalsIgnoreCase("")){
            lblThongBao.setText("Không được bỏ trống tên khách hàng");
            return false;
        }
        if(txtPhoneNumber.getText().trim().equalsIgnoreCase("")){
            lblThongBao.setText("Không được bỏ trống số điện thoại");
            return false;
        }
        if(numberValidate(txtPhoneNumber.getText()) == false){
            return false;
        }
        if(txtStaffID.getText().trim().equalsIgnoreCase("")){
            lblThongBao.setText("Không được bỏ trống mã nhân viên");
            return false;
        }
        return true;
    }
    @FXML
    // xóa dữ liệu trong bảng
    public void deleteData() {
        String sql = "UPDATE KHACHHANG SET isDeleted = 3 where makhachhang = '" + txtMaKhachHang.getText() + "'";
        executeQuery(sql);
        lblThongBao.setText("Xóa thành công");
        list.clear();
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String query = "SELECT MaKhachHang,TenKhachHang,MaNhanVienHoTro,SoDienThoai,TongTienDaChi,SoLanMuaHang FROM KhachHang where isDeleted=2 ";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                list.add(new Customer_DAO(
                        rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getString("MaNhanVienHoTro"),
                        rs.getString("SoDienThoai"),
                        rs.getFloat(String.valueOf("TongTienDaChi")),
                        rs.getInt("SoLanMuaHang")));
            }
            tblModel.setItems(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // fill dữ liệu được chọn lên textfield
    public void selectedID(){
        Customer_DAO customer_dao = tblModel.getSelectionModel().getSelectedItem();
        txtMaKhachHang.setText(customer_dao.getMaKhachHang());
        txtName.setText(customer_dao.getTenKhachHang());
        txtPhoneNumber.setText(customer_dao.getSoDienThoai());
        txtStaffID.setText(customer_dao.getMaNhanVienHoTro());
    }
}
