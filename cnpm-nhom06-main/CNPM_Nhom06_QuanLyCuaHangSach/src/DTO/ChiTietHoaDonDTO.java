/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author vosin
 */
public class ChiTietHoaDonDTO {
    private String mahd;
    private String masp;
    private String maKhuyenmai;
    private int dongia;
    private int soluong;
    private int thanhtien;

    private ChiTietHoaDonDTO(String mahd, String masp, int dongia, int soluong, String maKhuyenmai, int thanhtien) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getMaKhuyenmai() {
        return maKhuyenmai;
    }

    public void setMaKhuyenmai(String maKhuyenmai) {
        this.maKhuyenmai = maKhuyenmai;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public ChiTietHoaDonDTO(String mahd, String masp, String maKhuyenmai, int dongia, int soluong, int thanhtien) {
        this.mahd = mahd;
        this.masp = masp;
        this.maKhuyenmai = maKhuyenmai;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }
    
    public ChiTietHoaDonDTO(){}
    
    public ChiTietHoaDonDTO(ChiTietHoaDonDTO hd){
        this(hd.mahd,hd.masp,hd.dongia,hd.soluong,hd.maKhuyenmai,hd.thanhtien);
    }
    
}
