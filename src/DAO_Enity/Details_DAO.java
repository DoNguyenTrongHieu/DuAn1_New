package DAO_Enity;

public class Details_DAO {
    private int STT;
    private String MaHoaDon;
    private String MaSanPham;
    private String MaKhachHang;
    private String MaNhanVienXuatHoaDon;
    private String ThoiGianXuat;
    private String NgayXuat;
    private String TenSanPham;
    private int SoLuongSanPham;
    private float TongGiaTungSanPham;
    private String TrangThai;
    private String SoDienThoai;
    private float ThanhTien;

    public Details_DAO() {
    }

    public Details_DAO(int STT, String maHoaDon, String maSanPham, String maKhachHang, String maNhanVienXuatHoaDon, String thoiGianXuat, String ngayXuat, String tenSanPham, int soLuongSanPham, float tongGiaTungSanPham, String trangThai, String soDienThoai, float thanhTien) {
        this.STT = STT;
        MaHoaDon = maHoaDon;
        MaSanPham = maSanPham;
        MaKhachHang = maKhachHang;
        MaNhanVienXuatHoaDon = maNhanVienXuatHoaDon;
        ThoiGianXuat = thoiGianXuat;
        NgayXuat = ngayXuat;
        TenSanPham = tenSanPham;
        SoLuongSanPham = soLuongSanPham;
        TongGiaTungSanPham = tongGiaTungSanPham;
        TrangThai = trangThai;
        SoDienThoai = soDienThoai;
        ThanhTien = thanhTien;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        MaSanPham = maSanPham;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        MaKhachHang = maKhachHang;
    }

    public String getMaNhanVienXuatHoaDon() {
        return MaNhanVienXuatHoaDon;
    }

    public void setMaNhanVienXuatHoaDon(String maNhanVienXuatHoaDon) {
        MaNhanVienXuatHoaDon = maNhanVienXuatHoaDon;
    }

    public String getThoiGianXuat() {
        return ThoiGianXuat;
    }

    public void setThoiGianXuat(String thoiGianXuat) {
        ThoiGianXuat = thoiGianXuat;
    }

    public String getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        NgayXuat = ngayXuat;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public int getSoLuongSanPham() {
        return SoLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        SoLuongSanPham = soLuongSanPham;
    }

    public float getTongGiaTungSanPham() {
        return TongGiaTungSanPham;
    }

    public void setTongGiaTungSanPham(float tongGiaTungSanPham) {
        TongGiaTungSanPham = tongGiaTungSanPham;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float thanhTien) {
        ThanhTien = thanhTien;
    }
}
