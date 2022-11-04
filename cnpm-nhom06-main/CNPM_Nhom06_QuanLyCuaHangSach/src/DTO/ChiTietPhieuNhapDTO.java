/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author xenov
 */
public class ChiTietPhieuNhapDTO {
    private String mahd;
    private String masp;
    private int dongia;
    private int soluong;
    private int thanhtien;

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

    public ChiTietPhieuNhapDTO(String mahd, String masp, int dongia, int soluong, int thanhtien) {
        this.mahd = mahd;
        this.masp = masp;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }
    
    public ChiTietPhieuNhapDTO(){}
    public ChiTietPhieuNhapDTO(ChiTietPhieuNhapDTO hd){
        this(hd.mahd,hd.masp,hd.dongia,hd.soluong,hd.thanhtien);
    }
}
