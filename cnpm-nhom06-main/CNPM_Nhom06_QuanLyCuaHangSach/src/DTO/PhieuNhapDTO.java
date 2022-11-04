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
public class PhieuNhapDTO {
    private String mahd;
    private String manv;
    private String mancc;
    private String ghichu;
    private String ngaynhap;
    private int tongchi;

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getTongchi() {
        return tongchi;
    }

    public void setTongchi(int tongchi) {
        this.tongchi = tongchi;
    }
    
    public PhieuNhapDTO(){}
    public PhieuNhapDTO(String mahd, String manv, String mancc, String ghichu, String ngaynhap, int tongchi) {
        this.mahd = mahd;
        this.manv = manv;
        this.mancc = mancc;
        this.ghichu = ghichu;
        this.ngaynhap = ngaynhap;
        this.tongchi = tongchi;
    }
    public PhieuNhapDTO(PhieuNhapDTO hd){
        this(hd.mahd,hd.manv,hd.mancc,hd.ghichu,hd.ngaynhap,hd.tongchi);
    }
    
}
