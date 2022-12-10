package DAO_Enity;

public class Salary_DAO {
    private String MaVaiTro;
    private float luongCoBan;
    private float luongPhuCap;
    private int ngayCong;
    private int ngayCongChuan;
    private float tongLuong;

    public Salary_DAO() {
    }

    public Salary_DAO( String MaVaiTro, float luongCoBan, float luongPhuCap,int ngayCong, int ngayCongChuan, float tongLuong) {

        this.MaVaiTro = MaVaiTro;
        this.luongCoBan = luongCoBan;
        this.luongPhuCap = luongPhuCap;
        this.ngayCong = ngayCong;
        this.ngayCongChuan = ngayCongChuan;
        this.tongLuong = tongLuong;
    }


    public String getMaVaiTro() {
        return MaVaiTro;
    }

    public void setMaVaiTro(String MaVaiTro) {
        this.MaVaiTro = MaVaiTro;
    }

    public float getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public float getLuongPhuCap() {
        return luongPhuCap;
    }

    public void setLuongPhuCap(float luongPhuCap) {
        this.luongPhuCap = luongPhuCap;
    }

    public int getNgayCongChuan() {
        return ngayCongChuan;
    }

    public void setNgayCongChuan(int ngayCongChuan) {
        this.ngayCongChuan = ngayCongChuan;
    }

    public float getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(float tongLuong) {
        this.tongLuong = tongLuong;
    }

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }
}
