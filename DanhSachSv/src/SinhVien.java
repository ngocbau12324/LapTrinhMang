import java.util.Date;

public class SinhVien {
    String mssv;
    String ho, ten;
    String gioiTinh;
    String diaChi;
    String sdt;
    Float diemTB;
    Date ngaySinh;
    String email;
    public SinhVien(){};

    public SinhVien(String mssv, String ho, String ten, String diaChi, String sdt, Float diemTB, Date ngaySinh) {
        this.mssv = mssv;
        this.ho = ho;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.diemTB = diemTB;
        this.ngaySinh = ngaySinh;
        this.email=email;
        this.gioiTinh=gioiTinh;
    }

    public String getMssv() {
        return mssv;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(Float diemTB) {
        this.diemTB = diemTB;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv='" + mssv + '\'' +
                ", ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diemTB=" + diemTB +
                ", ngaySinh=" + ngaySinh +
                ", email='" + email + '\'' +
                '}';
    }
}
