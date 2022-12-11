package DAO_Enity;

public class Details_DAO {
    private int STT ;
    private String maHoaDon;
    private String maKhachHang;
    private String maNhanVienXuat;
    private String thoiGianXuat;
    private String ngayXuat;
    private String tenSanPham;
    private int soLuongSanPham;
    private float tongGia;
    private String trangThai;
    private String sdt;
    private float thanhTien;

    public Details_DAO() {
    }

    public Details_DAO(int STT, String maHoaDon, String maKhachHang, String maNhanVienXuat, String thoiGianXuat, String ngayXuat, String tenSanPham, int soLuongSanPham, float tongGia, String trangThai, String sdt, float thanhTien) {
        this.STT = STT;
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVienXuat = maNhanVienXuat;
        this.thoiGianXuat = thoiGianXuat;
        this.ngayXuat = ngayXuat;
        this.tenSanPham = tenSanPham;
        this.soLuongSanPham = soLuongSanPham;
        this.tongGia = tongGia;
        this.trangThai = trangThai;
        this.sdt = sdt;
        this.thanhTien = thanhTien;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVienXuat() {
        return maNhanVienXuat;
    }

    public void setMaNhanVienXuat(String maNhanVienXuat) {
        this.maNhanVienXuat = maNhanVienXuat;
    }

    public String getThoiGianXuat() {
        return thoiGianXuat;
    }

    public void setThoiGianXuat(String thoiGianXuat) {
        this.thoiGianXuat = thoiGianXuat;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public float getTongGia() {
        return tongGia;
    }

    public void setTongGia(float tongGia) {
        this.tongGia = tongGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
}
