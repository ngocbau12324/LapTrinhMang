/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv3lop;

import java.util.Date;

/**
 *
 * @author NGOC BAU
 */
public class SinhVienDTO {
    String mssv;
    String ho, ten;
    String gioiTinh;
    String diaChi;
    String sdt;
    Float diemTB;
    String ngaySinh;
    String email;
    public SinhVienDTO(){};

    public SinhVienDTO(String mssv, String ho, String ten, String diaChi, String sdt, Float diemTB, String ngaySinh,String email,String gioiTinh) {
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
