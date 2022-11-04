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
public class giohangDTO {
    String ma_san_pham,ten_san_pham;
    int so_luong,don_gia;

    public giohangDTO() {
    }

    public giohangDTO(String ma_san_pham, String ten_san_pham, int so_luong, int don_gia) {
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.so_luong = so_luong;
        this.don_gia = don_gia;
    }

    public String getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(String ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
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

    
    
    
}
