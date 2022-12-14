package DAO_Enity;

public class Attendance_DAO {
        private int Id;
        private String maNhanVien;
        private String maChamCong;
        private String hoTen;
        private String ngayCham;
        private String thoiGianCham;

    public Attendance_DAO () {
    }

    public Attendance_DAO(int id, String maNhanVien, String maChamCong, String hoTen, String ngayCham, String thoiGianCham) {
        Id = id;
        this.maNhanVien = maNhanVien;
        this.maChamCong = maChamCong;
        this.hoTen = hoTen;
        this.ngayCham = ngayCham;
        this.thoiGianCham = thoiGianCham;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaChamCong() {
        return maChamCong;
    }

    public void setMaChamCong(String maChamCong) {
        this.maChamCong = maChamCong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgayCham() {
        return ngayCham;
    }

    public void setNgayCham(String ngayCham) {
        this.ngayCham = ngayCham;
    }

    public String getThoiGianCham() {
        return thoiGianCham;
    }

    public void setThoiGianCham(String thoiGianCham) {
        this.thoiGianCham = thoiGianCham;
    }
}
