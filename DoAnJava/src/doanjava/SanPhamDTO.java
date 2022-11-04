/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

/**
 *
 * @author NGOC BAU
 */
public class SanPhamDTO {
    String maSanPham,tenSanPham,maTheLoai,maNhaCungCap;
    int soLuong,baoHanh,donGia;

    public SanPhamDTO() {
    }

    public SanPhamDTO(String maSanPham, String tenSanPham, String maTheLoai, String maNhaCungCap, int soLuong, int baoHanh, int donGia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.maTheLoai = maTheLoai;
        this.maNhaCungCap = maNhaCungCap;
        this.soLuong = soLuong;
        this.baoHanh = baoHanh;
        this.donGia = donGia;
    }

    public SanPhamDTO(String tenSanPham, String maTheLoai, String maNhaCungCap, int soLuong, int baoHanh, int donGia) {
        this.tenSanPham = tenSanPham;
        this.maTheLoai = maTheLoai;
        this.maNhaCungCap = maNhaCungCap;
        this.soLuong = soLuong;
        this.baoHanh = baoHanh;
        this.donGia = donGia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getBaoHanh() {
        return baoHanh;
    }

    public void setBaoHanh(int baoHanh) {
        this.baoHanh = baoHanh;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "SanPhamDTO{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", maTheLoai=" + maTheLoai + ", maNhaCungCap=" + maNhaCungCap + ", soLuong=" + soLuong + ", baoHanh=" + baoHanh + ", donGia=" + donGia + '}';
    }

    
}
