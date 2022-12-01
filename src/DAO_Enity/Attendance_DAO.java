package DAO_Enity;

public class Attendance_DAO {
        private String maChamCong;
        private String hoTen;
        private String ngayChamCong;
        private String chucVu;

    public Attendance_DAO() {
    }

    public Attendance_DAO(String maChamCong, String hoTen, String ngayChamCong, String chucVu) {
        this.maChamCong = maChamCong;
        this.hoTen = hoTen;
        this.ngayChamCong = ngayChamCong;
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

    public String getNgayChamCong() {
        return ngayChamCong;
    }

    public void setNgayChamCong(String ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
