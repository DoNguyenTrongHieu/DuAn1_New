package Controller;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ChangeSalary_Controller implements Initializable {

    ObservableList<String> roleList = FXCollections.observableArrayList("QL","NV","BV");

    @FXML
    private ComboBox<String> cboRole;

    @FXML
    private Label lbltest;

    @FXML
    private TextField txtBasicSalary,txtSubsideiesSalary,txtWorkingday;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cboRole.setVisibleRowCount(3);
        cboRole.setItems(roleList);
//        updateDataSalary();

    }
    Parent root = null;
    Scene scene = null;
    Stage stage = null;
    public void back(ActionEvent event) throws Exception{
        root = (Parent) FXMLLoader.load(this.getClass().getResource("../FXML_File/Pin_for_change_salary.fxml"));
        scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("../Css/MainMenu.css").toExternalForm());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(this.scene);
        stage.centerOnScreen();
        stage.setResizable(false);
//                stage.setFullScreen(true);
        stage.show();
    }
    public void updateDataSalary(){
        // nếu combo box ko được chọn thì hiển thị lbl phải chọn ít nhất 1
        if(cboRole.getSelectionModel().isEmpty()){
            // rổng thì lbl settext
            lbltest.setText("You need chose at least one role");
        }else{ // nếu ko rổng thì chạy dưới này
            try {
                if(cboRole.getSelectionModel().isSelected(0)){                      // lấy giá trị được chọn của combo box ở bị trí 0
                    if(txtBasicSalary.getText().trim().isEmpty()){
                        // if dùng để check xem text field có rổng k nếu có rỗng thì k làm gì ko rỗng thì thực hiện else
                    }else{
                        String role = "QL";                                               // sau khi có giá trị thì tạo 1 biến sql chứa mã chức vụ
                        String sqlQL = "UPDATE LUONG SET luongcoban="+txtBasicSalary.getText()+"  where [MaVaiTro]='"+role+"'";
                        execute(sqlQL);
                        lbltest.setText("Update successfully");
                    }
                    if(txtSubsideiesSalary.getText().trim().isEmpty()){
                        // if dùng để check xem text field có rổng k nếu có rỗng thì k làm gì ko rỗng thì thực hiện else
                    }else{
                        String role = "QL";
                        String sqlSubQL = "UPDATE LUONG SET luongphucap="+txtSubsideiesSalary.getText()+"  where [MaVaiTro]='"+role+"'";
                        execute(sqlSubQL);
                        lbltest.setText("Update successfully");
                    }
                    if(txtWorkingday.getText().trim().isEmpty()){
                        // if dùng để check xem text field có rổng k nếu có rỗng thì k làm gì ko rỗng thì thực hiện else
                    }else{
                        String role = "QL";
                        String sqlNgayCong = "UPDATE LUONG SET ngaycongchuan="+txtWorkingday.getText()+"  where [MaVaiTro]='"+role+"'";
                        execute(sqlNgayCong);
                        lbltest.setText("Update successfully");
                    }
                }
                if(cboRole.getSelectionModel().isSelected(1)){
                    if(txtBasicSalary.getText().trim().isEmpty()){

                    }else{
                        String role = "NV";
                        String sqlNV = "UPDATE LUONG SET luongcoban="+txtBasicSalary.getText()+"  where [MaVaiTro]='"+role+"'";
                        lbltest.setText("Update successfully");
                    }
                }
                if(cboRole.getSelectionModel().isSelected(1)){
                    if(txtBasicSalary.getText().trim().isEmpty()){

                    }else{
                        String role = "BV";
                        String sqlBV = "UPDATE LUONG SET luongcoban="+txtBasicSalary.getText()+"  where [MaVaiTro]='"+role+"'";
                        lbltest.setText("Update successfully");
                    }
                }
            }catch (Exception e){
                lbltest.setText("Kiểm tra lại giá trị bạn nhập đã có sai xót");
            }
        }
        



    }
    public void execute(String query){ // execute là hàm truy vấn ko trả về kết quả result
        Connected_Controller connected_controller = new Connected_Controller();
        Connection con = connected_controller.getConnection();
        Statement stm;
        try {
            stm = con.createStatement();
            stm.execute(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
