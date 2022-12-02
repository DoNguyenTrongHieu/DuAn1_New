package DAO_Enity;

public class product_DAO {
    private String MaSamPham;
    private String TenSanpham;
    private String Ngaynhaphang;
    private String Ngayhethan;
    private String SoLuong ;
    private Float DonGia;

    public product_DAO() {
    }
    public product_DAO(String MaSamPham, String TenSanpham, String Ngaynhaphang, String Ngayhethan, String SoLuong, Float DonGia) {
        this.MaSamPham = MaSamPham;
        this.TenSanpham = TenSanpham;
        this.Ngaynhaphang = Ngaynhaphang;
        this.Ngayhethan = Ngayhethan;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }
    public String getMaSamPham() {
        return MaSamPham;
    }

    public void setMaSamPham(String MaSamPham) {
        this.MaSamPham = MaSamPham;
    }

    public String getTenSanpham() {
        return TenSanpham;
    }

    public void setTenSanpham(String TenSanpham) {
        this.TenSanpham = TenSanpham;
    }

    public String getNgaynhaphang() {
        return Ngaynhaphang;
    }

    public void setNgaynhaphang(String Ngaynhaphang) {
        this.Ngaynhaphang = Ngaynhaphang;
    }

    public String getNgayhethan() {
        return Ngayhethan;
    }

    public void setNgayhethan(String Ngayhethan) {
        this.Ngayhethan = Ngayhethan;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Float getDonGia() {
        return DonGia;
    }

    public void setDonGia(Float DonGia) {
        this.DonGia = DonGia;
    }
}
