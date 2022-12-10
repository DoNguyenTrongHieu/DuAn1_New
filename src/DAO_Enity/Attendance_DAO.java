package DAO_Enity;

public class Attendance_DAO {
        private String maChamCong;
        private String hoTen;
        private String MaNhanVien;
        private String chucVu;

    public Attendance_DAO() {
    }

    public Attendance_DAO(String maChamCong, String hoTen, String MaNhanVien, String chucVu) {
        this.maChamCong = maChamCong;
        this.hoTen = hoTen;
        this.MaNhanVien = MaNhanVien;
        this.chucVu = chucVu;
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

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
