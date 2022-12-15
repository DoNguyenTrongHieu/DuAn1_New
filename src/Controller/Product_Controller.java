package Controller;


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

public class Product_Controller implements Initializable {


    @FXML
    Button btnExit;
    @FXML
    Label lblTB;
    @FXML
    TextField txtid,txtname,txtday,txtdat,txtslot,txtcost ;
    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private TableView<product_DAO> tblModel;

    @FXML
    private TableColumn<product_DAO, String> ProductID;

    @FXML
    private TableColumn<product_DAO, String> Productname;

    @FXML
    private TableColumn<product_DAO, String> Importdate;

    @FXML
    private TableColumn<product_DAO, String> Expirationdate;

    @FXML
    private TableColumn<product_DAO, Integer> Amount;

    @FXML
    private TableColumn<product_DAO, Float> Unitprice;

    ObservableList<product_DAO> list = FXCollections.observableArrayList(
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // hiển thị dự liệu lên table
        fillproduct();
        // loadTable();
//        selectedID();

    }
    public void fillproduct() {
        ProductID.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("MaSanPham"));
        Productname.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("TenSanPham"));
        Importdate.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("NgayNhapHang"));
        Expirationdate.setCellValueFactory(new PropertyValueFactory<product_DAO,String>("NgayHetHan"));
        Amount.setCellValueFactory(new PropertyValueFactory<product_DAO,Integer>("SoLuong"));
        Unitprice.setCellValueFactory(new PropertyValueFactory<product_DAO,Float>("dongia"));
        tblModel.setItems(list);
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String sql = "SELECT MASANPHAM,TENSANPHAM,NGAYNHAPHANG,NGAYHETHAN,SOLUONG,DONGIA FROM SANPHAM WHERE ISDELETED=2";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new product_DAO(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("NgayNhapHang"),
                        rs.getString("NgayHetHan"),
                        rs.getInt(String.valueOf("SoLuong")),
                        rs.getFloat("dongia")));
            }
            tblModel.setItems(list);
        } catch (Exception e) {

        }
    }
    public void insertValueproduct() {
        if(validate() == true){
            String sql = "INSERT INTO SANPHAM VALUES ('"+txtid.getText().toUpperCase()+"','"+txtname.getText()+"','"+txtday.getText()+"','"+txtdat.getText()+"',"+txtslot.getText()+",'"+txtcost.getText()+"',2)";
            executeQuery(sql);
            System.out.println("them thanh cong");
            list.clear();
            try {
                Connected_Controller connected_controller = new Connected_Controller();
                Connection connection1 = connected_controller.getConnection();

                String query = "SELECT MASANPHAM,TENSANPHAM,NGAYNHAPHANG,NGAYHETHAN,SOLUONG,DONGIA FROM SANPHAM WHERE ISDELETED=2";
                Statement statement = connection1.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    list.add(new product_DAO(
                            rs.getString("MaSanPham"),
                            rs.getString("TenSanPham"),
                            rs.getString("NgayNhapHang"),
                            rs.getString("NgayHetHan"),
                            rs.getInt(String.valueOf("SoLuong")),
                            rs.getFloat("dongia")));
                }
                tblModel.setItems(list);
                lblTB.setText("Tạo thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            lblTB.setText("Tạo thất bại");
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
    public boolean validate(){
        if(txtid.getText().trim().equalsIgnoreCase("")){
            lblTB.setText("Không được bỏ trống ID sản phẩm ");
            return false;
        }
        if(txtname.getText().trim().equalsIgnoreCase("")){
            lblTB.setText("Không được bỏ trống tên sản phẩm");
            return false;
        }

        return true;
    }
    public void deleteData() {
        String sql = "UPDATE SanPham SET ISDELETED = 3 where MASANPHAM = '"+ txtid.getText() +"'";
        executeQuery(sql);
        lblTB.setText("Xóa thành công");
        list.clear();
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection = connected_controller.getConnection();

            String query = "SELECT MASANPHAM,TENSANPHAM,NGAYNHAPHANG,NGAYHETHAN,SOLUONG,DONGIA FROM SANPHAM WHERE ISDELETED=2";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                list.add(new product_DAO(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("NgayNhapHang"),
                        rs.getString("NgayHetHan"),
                        rs.getInt(String.valueOf("SoLuong")),
                        rs.getFloat("dongia")));
            }
            tblModel.setItems(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void selectedID(){
        product_DAO product_DAO = tblModel.getSelectionModel().getSelectedItem();
        txtid.setText(product_DAO.getMaSanPham());
        txtname.setText(product_DAO.getTenSanPham());
        txtday.setText(product_DAO.getNgayNhapHang());
        txtdat.setText(product_DAO.getNgayHetHan());
        txtslot.setText(String.valueOf(product_DAO.getSoLuong()));
        txtcost.setText(String.valueOf(product_DAO.getDongia()));

    }
    public void executeUpdate(){
        String sql = "update SanPham set MaSanPham = '"+ txtid.getText()+"' ,TenSanPham=N'"+txtname.getText()+"', NgayNhapHang = '"+txtday.getText()+"', NgayHetHan = '"+txtdat.getText()+"', SoLuong = '"+ txtslot.getText()+"', dongia = '"+ txtcost.getText()+"' "+" where MaSanPham ='"+txtid.getText()+"'";
        executeQuery(sql);
        lblTB.setText("Cập nhật  thành công");
        list.clear();
        try {
            Connected_Controller connected_controller = new Connected_Controller();
            Connection connection1 = connected_controller.getConnection();

            String query = "SELECT MASANPHAM,TENSANPHAM,NGAYNHAPHANG,NGAYHETHAN,SOLUONG,DONGIA FROM SANPHAM WHERE ISDELETED=2";
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                list.add(new product_DAO(
                        rs.getString("MaSanPham"),
                        rs.getString("TenSanPham"),
                        rs.getString("NgayNhapHang"),
                        rs.getString("NgayHetHan"),
                        rs.getInt(String.valueOf("SoLuong")),
                        rs.getFloat("dongia")));
            }
            tblModel.setItems(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}