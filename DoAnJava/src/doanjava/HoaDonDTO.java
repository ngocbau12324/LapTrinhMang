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
public class HoaDonDTO {
    String idString, id_nhan_vienString, id_khach_hang, id_khuyen_mai;
    Date ngay_xuat;
    int tong_giam_gia, tong_tien_con_lai;

    public HoaDonDTO() {
    }

    public HoaDonDTO(String idString, String id_nhan_vienString, String id_khach_hang, String id_khuyen_mai, Date ngay_xuat, int tong_giam_gia, int tong_tien_con_lai) {
        this.idString = idString;
        this.id_nhan_vienString = id_nhan_vienString;
        this.id_khach_hang = id_khach_hang;
        this.id_khuyen_mai = id_khuyen_mai;
        this.ngay_xuat = ngay_xuat;
        this.tong_giam_gia = tong_giam_gia;
        this.tong_tien_con_lai = tong_tien_con_lai;
    }

    public HoaDonDTO(String id_nhan_vienString, String id_khach_hang, String id_khuyen_mai, Date ngay_xuat, int tong_giam_gia, int tong_tien_con_lai) {
        this.id_nhan_vienString = id_nhan_vienString;
        this.id_khach_hang = id_khach_hang;
        this.id_khuyen_mai = id_khuyen_mai;
        this.ngay_xuat = ngay_xuat;
        this.tong_giam_gia = tong_giam_gia;
        this.tong_tien_con_lai = tong_tien_con_lai;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

    public String getId_nhan_vienString() {
        return id_nhan_vienString;
    }

    public void setId_nhan_vienString(String id_nhan_vienString) {
        this.id_nhan_vienString = id_nhan_vienString;
    }

    public String getId_khach_hang() {
        return id_khach_hang;
    }

    public void setId_khach_hang(String id_khach_hang) {
        this.id_khach_hang = id_khach_hang;
    }

    public String getId_khuyen_mai() {
        return id_khuyen_mai;
    }

    public void setId_khuyen_mai(String id_khuyen_mai) {
        this.id_khuyen_mai = id_khuyen_mai;
    }

    public Date getNgay_xuat() {
        return ngay_xuat;
    }

    public void setNgay_xuat(Date ngay_xuat) {
        this.ngay_xuat = ngay_xuat;
    }

    public int getTong_giam_gia() {
        return tong_giam_gia;
    }

    public void setTong_giam_gia(int tong_giam_gia) {
        this.tong_giam_gia = tong_giam_gia;
    }

    public int getTong_tien_con_lai() {
        return tong_tien_con_lai;
    }

    public void setTong_tien_con_lai(int tong_tien_con_lai) {
        this.tong_tien_con_lai = tong_tien_con_lai;
    }

    @Override
    public String toString() {
        return "HoaDonDTO{" + "idString=" + idString + ", id_nhan_vienString=" + id_nhan_vienString + ", id_khach_hang=" + id_khach_hang + ", id_khuyen_mai=" + id_khuyen_mai + ", ngay_xuat=" + ngay_xuat + ", tong_giam_gia=" + tong_giam_gia + ", tong_tien_con_lai=" + tong_tien_con_lai + '}';
    }
    
}
