package Controller;

import DAO_Enity.Customer_DAO;
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

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Employees_Controller implements Initializable {
    @FXML
    public void exit(ActionEvent event) {
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
    private ToggleGroup gioiTinh;
    @FXML
    private Button btnThem;
    @FXML
    private Button btnXoa;
    @FXML
    private Button btnSua;
    @FXML
    private Button btnLamMoi;
    @FXML
    private Label lblThongBao;
    @FXML
    private TableView<Employees_DAO> table;
    @FXML
    private TableColumn<Employees_DAO, String> maNVColumn;
    @FXML
    private TableColumn<Employees_DAO, String> tenNVColumn;
    @FXML
    private TableColumn<Employees_DAO, String> ngaysinhColumn;
    @FXML
    private TableColumn<Employees_DAO, String> gioiTinhColumn;
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

    public void setCellTable() {
        maNVColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("maNv"));
        tenNVColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("hoTen"));
        ngaysinhColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("ngaySinh"));
        gioiTinhColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("gioiTinh"));
        maChamCongColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("maChamCong"));
        maChucVuColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("maChucVu"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("email"));
        sdtColumn.setCellValueFactory(new PropertyValueFactory<Employees_DAO, String>("soDienThoai"));
        table.setItems(listM);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();
            String sql = "SELECT MANV,HOTEN,NGAYSINH,GIOITINH,MACHAMCONG,MACHUCVU,EMAIL,SODIENTHOAI FROM NHANVIEN WHERE ISDELETED = 2";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listM.add(new Employees_DAO(
                        rs.getString("maNV"),
                        rs.getString("HoTen"),
                        rs.getString("ngaysinh"),
                        rs.getString("gioitinh"),
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
    public void executeStoredProc(String exec){
        Connected_Controller connect = new Connected_Controller();
        Connection con = connect.getConnection();
        CallableStatement callableStatement;
        try {
            callableStatement = con.prepareCall(exec);
            callableStatement.executeQuery();
            ResultSet rs = callableStatement.executeQuery();
        }catch (Exception e){
            System.out.println("Oke"); // ko trả về result nên báo lỗi
        }
    }

    public void insertValueEmployees() {
        String gioiTinh = null;
        if(rdbNam.isSelected()){
            gioiTinh = "Nam";
        }
        if(rdbNu.isSelected()){
            gioiTinh = "Nữ";
        }
        String tenChucVu = null;
        String taikhoan = null;
        String matkhau = null;
        if(txtMaChucVu.getText().toUpperCase().equalsIgnoreCase("QL")){
            tenChucVu = "Quản Lý";
            taikhoan = "admin";
            matkhau = "12345";
        }else{
            taikhoan = "null";
            matkhau = "null";
        }
        if(txtMaChucVu.getText().toUpperCase().equalsIgnoreCase("NV")){
            tenChucVu = "Nhân viên";
            taikhoan = "null";
            matkhau = "null";
        }
        if(txtMaChucVu.getText().toUpperCase().equalsIgnoreCase("BV")){
            tenChucVu = "Bảo vệ";
            taikhoan = "null";
            matkhau = "null";
        }
        if (validate() == true) {
//            String sql = "INSERT INTO NHANVIEN VALUES('"+txtMaNV.getText().toUpperCase()+"','"+txtMaChamCong.getText()+"','"+txtMaChucVu.getText().toUpperCase()+"',N'"+txtTenNV.getText()+"','"+txtNgaySinh.getText()+"',N'"+ s +"','"+txtEmail.getText()+"','"+txtSdt.getText()+"',2)";
            String exec = "{call ADD_CHUCVU('"+txtMaNV.getText().toUpperCase()+"','"+txtMaChamCong.getText()+"','"+txtMaChucVu.getText().toUpperCase()+"',N'"+txtTenNV.getText()+"','"+txtNgaySinh.getText()+"',N'"+gioiTinh+"','"+txtEmail.getText()+"','"+txtSdt.getText()+"',N'"+tenChucVu+"','"+taikhoan+"','"+matkhau+"',2)}";
            executeStoredProc(exec);
            System.out.println("them thanh cong");
            listM.clear();
            try {
                Connected_Controller connected_controller = new Connected_Controller();
                Connection connection1 = connected_controller.getConnection();

                String query = "SELECT MaNv,HoTen,NgaySinh,GioiTinh,MaChamCong,MaChucVu,Email,SoDienThoai FROM NhanVien where isDeleted=2 ";
                Statement statement = connection1.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    listM.add(new Employees_DAO(
                            rs.getString("maNV"),
                            rs.getString("HoTen"),
                            rs.getString("ngaysinh"),
                            rs.getString("gioitinh"),
                            rs.getString("machamcong"),
                            rs.getString("machucvu"),
                            rs.getString("email"),
                            rs.getString("soDienThoai")));
                }
                table.setItems(listM);
                lblThongBao.setText("Tạo thành viên thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            lblThongBao.setText("Tạo thành viên thất bại");
        }
    }

    public boolean validate() {
        if (txtMaNV.getText().trim().equalsIgnoreCase("")) {
            lblThongBao.setText("Không được bỏ trống mã nhân viên");
            return false;
        }
        if (txtTenNV.getText().trim().equalsIgnoreCase("")) {
            lblThongBao.setText("Không được bỏ trống tên nhân viên");
            return false;
        }
        if (txtNgaySinh.getText().trim().equalsIgnoreCase("")) {
            lblThongBao.setText("Không được bỏ trống ngày sinh");
            return false;
        }
        if (!(rdbNam.isSelected() || rdbNu.isSelected())) {
            lblThongBao.setText("Không được bỏ trống giới tính");
            return false;
        }
        if (txtMaChamCong.getText().trim().equalsIgnoreCase("")) {
            lblThongBao.setText("Không được bỏ trống mã chấm công");
            return false;
        }
        if (txtMaChucVu.getText().trim().equalsIgnoreCase("")) {
            lblThongBao.setText("Không được bỏ trống mã chức vụ");
            return false;
        }
        if (txtEmail.getText().trim().equalsIgnoreCase("")) {
            lblThongBao.setText("Không được bỏ trống email");
            return false;
        }
        if (txtSdt.getText().trim().equalsIgnoreCase("")) {
            lblThongBao.setText("Không được bỏ trống sđt");
            return false;
        }
        return true;
    }

    public void selectedID(){
        Employees_DAO employees_dao = table.getSelectionModel().getSelectedItem();
        txtMaNV.setText(employees_dao.getMaNv());
        txtTenNV.setText(employees_dao.getHoTen());
        txtNgaySinh.setText(employees_dao.getNgaySinh());
        if(gioiTinhColumn.equals("false")){
            rdbNu.setSelected(true);
        }
        else{
            rdbNam.setSelected(true);
        }
        txtMaChamCong.setText(employees_dao.getMaChamCong());
        txtMaChucVu.setText(employees_dao.getMaChucVu());
        txtEmail.setText(employees_dao.getEmail());
        txtSdt.setText(employees_dao.getSoDienThoai());
    }

    public void deleteData() {
        String sql = "UPDATE NHANVIEN SET ISDELETED = 3 WHERE MANV = '" + txtMaNV.getText() + "'";
        executeQuery(sql);
        lblThongBao.setText("Xóa thành công");
        listM.clear();
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String query = "SELECT MANV,HOTEN,NGAYSINH,GIOITINH,MACHAMCONG,MACHUCVU,EMAIL,SODIENTHOAI FROM NHANVIEN WHERE ISDELETED = 2";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                listM.add(new Employees_DAO(
                        rs.getString("maNV"),
                        rs.getString("HoTen"),
                        rs.getString("ngaysinh"),
                        rs.getString("gioitinh"),
                        rs.getString("machamcong"),
                        rs.getString("machucvu"),
                        rs.getString("email"),
                        rs.getString("soDienThoai")));
            }
            table.setItems(listM);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void resetData(){
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtNgaySinh.setText("");
        rdbNam.setSelected(false);
        rdbNu.setSelected(false);
        txtMaChamCong.setText("");
        txtMaChucVu.setText("");
        txtEmail.setText("");
        txtSdt.setText("");
    }

    public void executeUpdate(){
        String s = null;
        if(rdbNam.isSelected()){
            s = "false";
        }
        if(rdbNu.isSelected()){
            s = "true";
        }
        String v1 = txtMaNV.getText();
        String sql = "update NhanVien set maNv= '"+v1+"' , hoTen=N'"+txtTenNV.getText()+"', ngaySinh = '"+txtNgaySinh.getText()+"', gioiTinh = '"+s+"', maChamCong = '"+txtMaChamCong.getText()+"' , maChucVu = '"+txtMaChucVu.getText()+"', email = '"+txtEmail.getText()+"', soDienThoai = '"+txtSdt.getText()+"' "+" where maNv ='"+v1+"'";
        executeQuery(sql);
        lblThongBao.setText("Cập nhật thành công");
        listM.clear();
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String query = "SELECT MANV,HOTEN,NGAYSINH,GIOITINH,MACHAMCONG,MACHUCVU,EMAIL,SODIENTHOAI FROM NHANVIEN WHERE ISDELETED = 2";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                listM.add(new Employees_DAO(
                        rs.getString("maNV"),
                        rs.getString("HoTen"),
                        rs.getString("ngaysinh"),
                        rs.getString("gioitinh"),
                        rs.getString("machamcong"),
                        rs.getString("machucvu"),
                        rs.getString("email"),
                        rs.getString("soDienThoai")));
            }
            table.setItems(listM);
        } catch (Exception ex) {
            ex.printStackTrace();
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
