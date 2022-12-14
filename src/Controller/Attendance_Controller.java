package Controller;

import DAO_Enity.Attendance_DAO;
import JDBC_Controller.Connected_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Attendance_Controller implements Initializable {
    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML
    TextField txtAttendance;

    @FXML
    private TableView<Attendance_DAO> tblAttendance;

    @FXML
    private TableColumn<Attendance_DAO, String> DateIn;

    @FXML
    private TableColumn<Attendance_DAO, Integer> ID;

    @FXML
    private TableColumn<Attendance_DAO, String> StaffID;

    @FXML
    private TableColumn<Attendance_DAO, String> StaffName;

    @FXML
    private TableColumn<Attendance_DAO, String> TimeIn;


    ObservableList<Attendance_DAO> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillDataToTable();
    }
    public void fillDataToTable(){
        ID.setCellValueFactory(new PropertyValueFactory<Attendance_DAO,Integer>("Id"));
        StaffID.setCellValueFactory(new PropertyValueFactory<Attendance_DAO,String>("maNhanVien"));
        StaffName.setCellValueFactory(new PropertyValueFactory<Attendance_DAO,String>("hoTen"));
        DateIn.setCellValueFactory(new PropertyValueFactory<Attendance_DAO,String>("ngayCham"));
        TimeIn.setCellValueFactory(new PropertyValueFactory<Attendance_DAO,String>("thoiGianCham"));
        tblAttendance.setItems(list);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();
            String sql = "SELECT SOTHUTU,MANHANVIEN,CHAMCONG.MACHAMCONG,NHANVIEN.HOTEN,NGAYCHAMCONG,THOIGIANCHAMCONG FROM CHAMCONG INNER JOIN NHANVIEN ON CHAMCONG.MANHANVIEN = NHANVIEN.MANV";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                list.add(new Attendance_DAO(
                    rs.getInt("SOTHUTU"),
                    rs.getString("MANHANVIEN"),
                    rs.getString("MACHAMCONG"),
                    rs.getString("HOTEN"),
                    rs.getString("NGAYCHAMCONG"),
                    rs.getString("THOIGIANCHAMCONG")
                ));
            }
            tblAttendance.setItems(list);
        }catch (Exception e){
            e.printStackTrace();
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
    public void insertChamCong (){
        String exec = "{call SP_CHAMCONG('"+txtAttendance.getText()+"')}";
        executeStoredProc(exec);
        list.clear();
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();
            String sql = "SELECT SOTHUTU,MANHANVIEN,CHAMCONG.MACHAMCONG,NHANVIEN.HOTEN,NGAYCHAMCONG,THOIGIANCHAMCONG FROM CHAMCONG INNER JOIN NHANVIEN ON CHAMCONG.MANHANVIEN = NHANVIEN.MANV";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                list.add(new Attendance_DAO(
                        rs.getInt("SOTHUTU"),
                        rs.getString("MANHANVIEN"),
                        rs.getString("MACHAMCONG"),
                        rs.getString("HOTEN"),
                        rs.getString("NGAYCHAMCONG"),
                        rs.getString("THOIGIANCHAMCONG")
                ));
            }
            tblAttendance.setItems(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

