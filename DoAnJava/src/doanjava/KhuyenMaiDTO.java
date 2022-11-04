/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import java.util.Date;

/**
 *
 * @author NGOC BAU
 */
public class KhuyenMaiDTO {
    String id, ten;
    Date ngay_bat_dau, ngay_ket_thuc;
    int phan_tram;

    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(String id, String ten, Date ngay_bat_dau, Date ngay_ket_thuc, int phan_tram) {
        this.id = id;
        this.ten = ten;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
        this.phan_tram = phan_tram;
    }

    public KhuyenMaiDTO(String ten, Date ngay_bat_dau, Date ngay_ket_thuc, int phan_tram) {
        this.ten = ten;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
        this.phan_tram = phan_tram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(Date ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public Date getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(Date ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public int getPhan_tram() {
        return phan_tram;
    }

    public void setPhan_tram(int phan_tram) {
        this.phan_tram = phan_tram;
    }

    @Override
    public String toString() {
        return "KhuyenMaiDTO{" + "id=" + id + ", ten=" + ten + ", ngay_bat_dau=" + ngay_bat_dau + ", ngay_ket_thuc=" + ngay_ket_thuc + ", phan_tram=" + phan_tram + '}';
    }

    
    
}
