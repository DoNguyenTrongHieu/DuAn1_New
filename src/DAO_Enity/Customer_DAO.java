package DAO_Enity;

public class Customer_DAO {
    private String maKhachHang;
    private String tenKhachHang;
    private String maNhanVienHoTro;
    private String maHoaDon;
    private String soDienThoai;
    private Float tongTienDaChi;
    private int soLanMuaHang;

    public Customer_DAO() {
    }

    public Customer_DAO(String maKhachHang, String tenKhachHang, String maNhanVienHoTro, String maHoaDon, String soDienThoai, Float tongTienDaChi, int soLanMuaHang) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.maNhanVienHoTro = maNhanVienHoTro;
        this.maHoaDon = maHoaDon;
        this.soDienThoai = soDienThoai;
        this.tongTienDaChi = tongTienDaChi;
        this.soLanMuaHang = soLanMuaHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaNhanVienHoTro() {
        return maNhanVienHoTro;
    }

    public void setMaNhanVienHoTro(String maNhanVienHoTro) {
        this.maNhanVienHoTro = maNhanVienHoTro;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Float getTongTienDaChi() {
        return tongTienDaChi;
    }

    public void setTongTienDaChi(Float tongTienDaChi) {
        this.tongTienDaChi = tongTienDaChi;
    }

    public int getSoLanMuaHang() {
        return soLanMuaHang;
    }

    public void setSoLanMuaHang(int soLanMuaHang) {
        this.soLanMuaHang = soLanMuaHang;
    }
}
