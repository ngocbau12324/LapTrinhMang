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
public class HoaDonDTO {
    private String mahd;
    private String manv;
    private String makh;
    private String ghichu;
    private String ngayxuat;
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

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(String ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public int getTongchi() {
        return tongchi;
    }

    public void setTongchi(int tongchi) {
        this.tongchi = tongchi;
    }
    
    public HoaDonDTO(){}
    public HoaDonDTO(String mahd, String manv, String makh, String ghichu, String ngayxuat, int tongchi) {
        this.mahd = mahd;
        this.manv = manv;
        this.makh = makh;
        this.ghichu = ghichu;
        this.ngayxuat = ngayxuat;
        this.tongchi = tongchi;
    }
    public HoaDonDTO(HoaDonDTO hd){
        this(hd.mahd,hd.manv,hd.makh,hd.ghichu,hd.ngayxuat,hd.tongchi);
    }
}
