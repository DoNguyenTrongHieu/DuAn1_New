package DAO_Enity;

public class product_DAO {
    private String MaSanPham;
    private String TenSanPham;
    private String NgayNhapHang;
    private String NgayHetHan;
    private int SoLuong;
    private Float Dongia;

    public product_DAO() {
    }

    public product_DAO(String tenSanPham, Float dongia) {
        TenSanPham = tenSanPham;
        Dongia = dongia;
    }

    public product_DAO(String maSanPham, String tenSanPham, String ngayNhapHang, String ngayHetHan, int soLuong, Float dongia) {
        MaSanPham = maSanPham;
        TenSanPham = tenSanPham;
        NgayNhapHang = ngayNhapHang;
        NgayHetHan = ngayHetHan;
        SoLuong = soLuong;
        Dongia = dongia;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        MaSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public String getNgayNhapHang() {
        return NgayNhapHang;
    }

    public void setNgayNhapHang(String ngayNhapHang) {
        NgayNhapHang = ngayNhapHang;
    }

    public String getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        NgayHetHan = ngayHetHan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public Float getDongia() {
        return Dongia;
    }

    public void setDongia(Float dongia) {
        Dongia = dongia;
    }
}