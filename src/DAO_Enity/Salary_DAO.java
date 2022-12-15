package DAO_Enity;

public class Salary_DAO {
    private int soThuTu;
    private String maNhanVien;
    private String luongCoBan;
    private String luongPhuCap;
    private String ngayCongChuan;
    private String ngayCongThucTe;
    private String tongLuong;
    public Salary_DAO() {
    }

    public Salary_DAO(int soThuTu, String maNhanVien, String luongCoBan, String luongPhuCap, String ngayCongChuan, String ngayCongThucTe,String tongLuong) {
        this.soThuTu = soThuTu;
        this.maNhanVien = maNhanVien;
        this.luongCoBan = luongCoBan;
        this.luongPhuCap = luongPhuCap;
        this.ngayCongChuan = ngayCongChuan;
        this.ngayCongThucTe = ngayCongThucTe;
        this.tongLuong = tongLuong;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(String luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public String getLuongPhuCap() {
        return luongPhuCap;
    }

    public void setLuongPhuCap(String luongPhuCap) {
        this.luongPhuCap = luongPhuCap;
    }

    public String getNgayCongChuan() {
        return ngayCongChuan;
    }

    public void setNgayCongChuan(String ngayCongChuan) {
        this.ngayCongChuan = ngayCongChuan;
    }

    public String getNgayCongThucTe() {
        return ngayCongThucTe;
    }

    public void setNgayCongThucTe(String ngayCongThucTe) {
        this.ngayCongThucTe = ngayCongThucTe;
    }

    public String getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(String tongLuong) {
        this.tongLuong = tongLuong;
    }
}
