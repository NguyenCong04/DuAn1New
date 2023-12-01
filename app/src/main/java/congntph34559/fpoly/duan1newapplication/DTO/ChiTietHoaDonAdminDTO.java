package congntph34559.fpoly.duan1newapplication.DTO;

public class ChiTietHoaDonAdminDTO {
    private int id_chi_tiet_hoa_don;
    private int id_san_pham;
    private int id_hoa_don;
    private String ten_san_pham;
    private int so_luong;
    private int tong_tien_hoa_don;
    private int so_luong_ban;

    public ChiTietHoaDonAdminDTO() {
    }

    public ChiTietHoaDonAdminDTO(int id_chi_tiet_hoa_don, int id_san_pham, int id_hoa_don, String ten_san_pham, int so_luong, int tong_tien_hoa_don) {
        this.id_chi_tiet_hoa_don = id_chi_tiet_hoa_don;
        this.id_san_pham = id_san_pham;
        this.id_hoa_don = id_hoa_don;
        this.ten_san_pham = ten_san_pham;
        this.so_luong = so_luong;
        this.tong_tien_hoa_don = tong_tien_hoa_don;
    }

    public ChiTietHoaDonAdminDTO(String ten_san_pham, int so_luong_ban) {
        this.ten_san_pham = ten_san_pham;
        this.so_luong_ban = so_luong_ban;
    }

    public int getId_chi_tiet_hoa_don() {
        return id_chi_tiet_hoa_don;
    }

    public void setId_chi_tiet_hoa_don(int id_chi_tiet_hoa_don) {
        this.id_chi_tiet_hoa_don = id_chi_tiet_hoa_don;
    }

    public int getId_san_pham() {
        return id_san_pham;
    }

    public void setId_san_pham(int id_san_pham) {
        this.id_san_pham = id_san_pham;
    }

    public int getId_hoa_don() {
        return id_hoa_don;
    }

    public void setId_hoa_don(int id_hoa_don) {
        this.id_hoa_don = id_hoa_don;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getTong_tien_hoa_don() {
        return tong_tien_hoa_don;
    }

    public void setTong_tien_hoa_don(int tong_tien_hoa_don) {
        this.tong_tien_hoa_don = tong_tien_hoa_don;
    }

    public int getSo_luong_ban() {
        return so_luong_ban;
    }

    public void setSo_luong_ban(int so_luong_ban) {
        this.so_luong_ban = so_luong_ban;
    }
}
