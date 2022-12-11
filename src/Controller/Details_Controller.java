package Controller;

import DAO_Enity.Customer_DAO;
import DAO_Enity.Details_DAO;
import DAO_Enity.product_DAO;
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

public class Details_Controller implements Initializable {
    @FXML
    Button btnExit;

    public void exit(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    private TableView<Details_DAO> tblModel;
    @FXML
    private TableColumn<Details_DAO, String> STT;
    @FXML
    private TableColumn<Details_DAO, String> maHoaDon;
    @FXML
    private TableColumn<Details_DAO, String> maKhachHang;
    @FXML
    private TableColumn<Details_DAO, String> maNhanVienXuat;
    @FXML
    private TableColumn<Details_DAO, String> thoiGianXuat;
    @FXML
    private TableColumn<Details_DAO, String> ngayXuat;
    @FXML
    private TableColumn<Details_DAO, String> tenSanPham;
    @FXML
    private TableColumn<Details_DAO, Integer> soLuongSanPham;
    @FXML
    private TableColumn<Details_DAO, Float> tongGia;
    @FXML
    private TableColumn<Details_DAO, String> trangThai;
    @FXML
    private TableColumn<Details_DAO, String> sdt;
    @FXML
    private TableColumn<Details_DAO, Float> thanhTien;

    ObservableList<Details_DAO> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showlist();
    }
    public void showlist() {
        //cái này ko biết để tìm hiểu sau chạy là được
        STT.setCellValueFactory(new PropertyValueFactory<Details_DAO, String>("STT"));
        maHoaDon.setCellValueFactory(new PropertyValueFactory<Details_DAO, String>("MaHoaDon"));
        maKhachHang.setCellValueFactory(new PropertyValueFactory<Details_DAO, String>("MaSanPham"));
        maNhanVienXuat.setCellValueFactory(new PropertyValueFactory<Details_DAO, String>("MaKhachHang"));
        thoiGianXuat.setCellValueFactory(new PropertyValueFactory<Details_DAO, String>("MaNhanVienXuatHoaDon"));
        ngayXuat.setCellValueFactory(new PropertyValueFactory<Details_DAO, String>("ThoiGianXuat"));
        tenSanPham.setCellValueFactory(new PropertyValueFactory<Details_DAO, String>("NgayXuat"));
        soLuongSanPham.setCellValueFactory(new PropertyValueFactory<Details_DAO, Integer>("TenSanPham"));
        tongGia.setCellValueFactory(new PropertyValueFactory<Details_DAO, Float>("SoLuongSanPham"));
        trangThai.setCellValueFactory(new PropertyValueFactory<Details_DAO, String>("TongGiaTungSanPham"));
        sdt.setCellValueFactory(new PropertyValueFactory<Details_DAO, String>("TrangThai"));
        thanhTien.setCellValueFactory(new PropertyValueFactory<Details_DAO, Float>("SoDienThoai"));

        //setItem cho table có tên là tblModel
        tblModel.setItems(list);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String sql = "SELECT STT,MaHoaDon,MaKhachHang,MaNhanVienXuatHoaDon,ThoiGianXuat,NgayXuat,TenSanPham,SoLuongSanPham,TongGiaTungSanPham,TrangThai,SoDienThoai,ThanhTien FROM HoaDonChiTiet where isDeleted=2 ";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Details_DAO(
                        rs.getString("STT"),
                        rs.getString("MaHoaDon"),
                        rs.getString("MaSanPham"),
                        rs.getString("MaKhachHang"),
                        rs.getString("MaNhanVienXuatHoaDon"),
                        rs.getString("ThoiGianXuat"),
                        rs.getString("NgayXuat"),
                        rs.getString("TenSanPham"),
                        rs.getInt("SoLuongSanPham"),
                        rs.getFloat("TongGiaTungSanPham"),
                        rs.getString("TrangThai"),
                        rs.getString("SoDienThoai"),
                        rs.getFloat("ThanhTien")));
            }
            tblModel.setItems(list);
        } catch (Exception e) {

        }
    }
}
