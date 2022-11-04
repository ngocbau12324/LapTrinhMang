/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MASOTHUE;

/**
 *
 * @author NGOC BAU
 */
public class Info {
    String ten;
    String tenQuocTe;
    String tenVietTac ;
    String maSoThue;
    String diaChi ;
    String nguoiDaiDien ;
    String dienThoai ; 
    String ngayHoatDong;
    String quanLyBoi ;
    String loaiHinhDN;
    String tinhTrang ;

    public Info() {
    }

    public Info(String ten, String tenQuocTe, String tenVietTac, String maSoThue, String diaChi, String nguoiDaiDien, String dienThoai, String ngayHoatDong, String quanLyBoi, String loaiHinhDN, String tinhTrang) {
        this.ten = ten;
        this.tenQuocTe = tenQuocTe;
        this.tenVietTac = tenVietTac;
        this.maSoThue = maSoThue;
        this.diaChi = diaChi;
        this.nguoiDaiDien = nguoiDaiDien;
        this.dienThoai = dienThoai;
        this.ngayHoatDong = ngayHoatDong;
        this.quanLyBoi = quanLyBoi;
        this.loaiHinhDN = loaiHinhDN;
        this.tinhTrang = tinhTrang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenQuocTe() {
        return tenQuocTe;
    }

    public void setTenQuocTe(String tenQuocTe) {
        this.tenQuocTe = tenQuocTe;
    }

    public String getTenVietTac() {
        return tenVietTac;
    }

    public void setTenVietTac(String tenVietTac) {
        this.tenVietTac = tenVietTac;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNguoiDaiDien() {
        return nguoiDaiDien;
    }

    public void setNguoiDaiDien(String nguoiDaiDien) {
        this.nguoiDaiDien = nguoiDaiDien;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getNgayHoatDong() {
        return ngayHoatDong;
    }

    public void setNgayHoatDong(String ngayHoatDong) {
        this.ngayHoatDong = ngayHoatDong;
    }

    public String getQuanLyBoi() {
        return quanLyBoi;
    }

    public void setQuanLyBoi(String quanLyBoi) {
        this.quanLyBoi = quanLyBoi;
    }

    public String getLoaiHinhDN() {
        return loaiHinhDN;
    }

    public void setLoaiHinhDN(String loaiHinhDN) {
        this.loaiHinhDN = loaiHinhDN;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
