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
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
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
    private TableView<Attendance_DAO> tblAttendance;

    @FXML
    private TableColumn<Attendance_DAO, String> attendanceID;

    @FXML
    private TableColumn<Attendance_DAO, String> date;

    @FXML
    private TableColumn<Attendance_DAO, String> name;

    @FXML
    private TableColumn<Attendance_DAO, String> role;

    ObservableList<Attendance_DAO> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillDataToTable();
    }
    public void fillDataToTable(){
        attendanceID.setCellValueFactory(new PropertyValueFactory<Attendance_DAO,String>("maChamCong"));
        name.setCellValueFactory(new PropertyValueFactory<Attendance_DAO,String>("hoTen"));
        date.setCellValueFactory(new PropertyValueFactory<Attendance_DAO,String>("ngayChamCong"));
        role.setCellValueFactory(new PropertyValueFactory<Attendance_DAO,String>("chucVu"));
        tblAttendance.setItems(list);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();
            String sql = "select MaChamCong,Ten,NgayChamCong,ChucVu from ChamCong";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                list.add(new Attendance_DAO(
                   rs.getString("MaChamCong"),
                   rs.getString("Ten"),
                   rs.getString("NgayChamCong"),
                   rs.getString("ChucVu")
                ));
            }
            tblAttendance.setItems(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

