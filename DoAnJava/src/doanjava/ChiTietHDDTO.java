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
public class ChiTietHDDTO {
    String id_hoa_donString, id_san_pham;
    int so_luong, don_gia, thanh_tien;

    public ChiTietHDDTO() {
    }

    public ChiTietHDDTO(String id_hoa_donString, String id_san_pham, int so_luong, int don_gia, int thanh_tien) {
        this.id_hoa_donString = id_hoa_donString;
        this.id_san_pham = id_san_pham;
        this.so_luong = so_luong;
        this.don_gia = don_gia;
        this.thanh_tien = thanh_tien;
    }

    public String getId_hoa_donString() {
        return id_hoa_donString;
    }

    public void setId_hoa_donString(String id_hoa_donString) {
        this.id_hoa_donString = id_hoa_donString;
    }

    public String getId_san_pham() {
        return id_san_pham;
    }

    public void setId_san_pham(String id_san_pham) {
        this.id_san_pham = id_san_pham;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(int don_gia) {
        this.don_gia = don_gia;
    }

    public int getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(int thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

    @Override
    public String toString() {
        return "ChiTietHDDTO{" + "id_hoa_donString=" + id_hoa_donString + ", id_san_pham=" + id_san_pham + ", so_luong=" + so_luong + ", don_gia=" + don_gia + ", thanh_tien=" + thanh_tien + '}';
    }
    
    
}
