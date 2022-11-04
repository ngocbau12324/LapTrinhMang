/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import java.util.Date;
import javax.net.ssl.HostnameVerifier;

/**
 *
 * @author NGOC BAU
 */
public class KhachHangDTO {
    private String maKhachHang;
    private String ho;
    private String ten;
    private Date ngaySinhDate;
    private String diaChiString;
    private String soDienThoai;
    private String email;
    public KhachHangDTO(){};

    public KhachHangDTO(String ho, String ten, Date ngaySinhDate, String diaChiString, String soDienThoai, String email) {
        this.ho = ho;
        this.ten = ten;
        this.ngaySinhDate = ngaySinhDate;
        this.diaChiString = diaChiString;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public KhachHangDTO(String maKhachHang, String ho, String ten, Date ngaySinhDate, String diaChiString, String soDienThoai, String email) {
        this.maKhachHang = maKhachHang;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinhDate = ngaySinhDate;
        this.diaChiString = diaChiString;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaySinhDate(Date ngaySinhDate) {
        this.ngaySinhDate = ngaySinhDate;
    }

    public void setDiaChiString(String diaChiString) {
        this.diaChiString = diaChiString;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public Date getNgaySinhDate() {
        return ngaySinhDate;
    }

    public String getDiaChiString() {
        return diaChiString;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "KhachHangDTO{" + "maKhachHang=" + maKhachHang + ", ho=" + ho + ", ten=" + ten + ", ngaySinhDate=" + ngaySinhDate + ", diaChiString=" + diaChiString + ", soDienThoai=" + soDienThoai + ", email=" + email + '}';
    }
    
    
}
