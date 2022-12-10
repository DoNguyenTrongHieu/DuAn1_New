package Controller;

import DAO_Enity.Customer_DAO;
import DAO_Enity.Salary_DAO;
import JDBC_Controller.Connected_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Salary_Controller implements Initializable {


    @FXML
    private TableView<Salary_DAO> tblModel;

    @FXML
    private TableColumn<Salary_DAO, String> MaVaiTro;

    @FXML
    private TableColumn<Salary_DAO, Float> basicSalary;

    @FXML
    private TableColumn<Salary_DAO, String> employeesID;

    @FXML
    private TableColumn<Salary_DAO, Float> salary;

    @FXML
    private TableColumn<Salary_DAO, Integer> standard_working_day;

    @FXML
    private TableColumn<Salary_DAO, Float> subsidiesSalary;

    @FXML
    private TableColumn<Salary_DAO, Integer> workday;


    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML
    AnchorPane anchorPanerSalary;

    @FXML
    public void backToEmployees(ActionEvent event) throws Exception {
        AnchorPane anchoraPane = FXMLLoader.load(getClass().getResource("../FXML_File/Employees.fxml"));
        anchorPanerSalary.getChildren().setAll(anchoraPane);
    }

    ObservableList<Salary_DAO> salaryList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showSalaryList();
    }

    public void showSalaryList(){
        employeesID.setCellValueFactory(new PropertyValueFactory<Salary_DAO,String>("maNhanVien"));
        MaVaiTro.setCellValueFactory(new PropertyValueFactory<Salary_DAO,String>("MaVaiTro"));
        basicSalary.setCellValueFactory(new PropertyValueFactory<Salary_DAO,Float>("luongCoBan"));
        subsidiesSalary.setCellValueFactory(new PropertyValueFactory<Salary_DAO,Float>("luongPhuCap"));
        workday.setCellValueFactory(new PropertyValueFactory<Salary_DAO,Integer>("ngayCong"));
        standard_working_day.setCellValueFactory(new PropertyValueFactory<Salary_DAO,Integer>("ngayCongChuan"));
        salary.setCellValueFactory(new PropertyValueFactory<Salary_DAO,Float>("tongLuong"));

        tblModel.setItems(salaryList);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String sql = "SELECT manhanvien,MaVaiTro,luongcoban,luongphucap,ngaycongchuan,ngaycong,tongluong FROM luong";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                salaryList.add(new Salary_DAO(
                    rs.getString("Manhanvien"),
                    rs.getString("MaVaiTro"),
                    rs.getFloat("luongcoban"),
                    rs.getFloat("luongphucap"),
                    rs.getInt("ngaycong"),
                    rs.getInt("ngaycongchuan"),
                    rs.getFloat("tongluong")
                ));

            }
            tblModel.setItems(salaryList);
        } catch (Exception e) {
e.printStackTrace();
        }

    }
    @FXML
    public void openSceneSecurity(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(this.getClass().getResource("../FXML_File/Pin_for_change_salary.fxml"));
        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("Css/SecurityScene.css").toExternalForm());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
//                stage.setFullScreen(true);
        stage.show();
    }
}
