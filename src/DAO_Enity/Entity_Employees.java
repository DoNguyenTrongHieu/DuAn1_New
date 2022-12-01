package DAO_Enity;

import DAO_Enity.Customer_DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Entity_Employees {
    private String maNV;
    private String tenNV;
    private String ngaysinh;
    private String gioitinh;
    private String machamcong;
    private String machucvu;
    private String email;
    private String sdt;

    public Entity_Employees(String string, String nv, String ngaysinh, String gioitinh, String maNV, String tenNV) {
    }

    public Entity_Employees(String maNV, String tenNV, String ngaysinh, String gioitinh, String machamcong, String machucvu, String email, String sdt) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.machamcong = machamcong;
        this.machucvu = machucvu;
        this.email = email;
        this.sdt = sdt;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getMachamcong() {
        return machamcong;
    }

    public void setMachamcong(String machamcong) {
        this.machamcong = machamcong;
    }

    public String getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }


}
