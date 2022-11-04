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
public class NhaXuatBanDTO {
    private String ma;
    private String ten;
    private String diachi;
//    private String sdt;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diachi;
    }

    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }
    
    
    public NhaXuatBanDTO(){}
    public NhaXuatBanDTO(String ma, String ten, String diachi) {
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
    }
    public NhaXuatBanDTO(NhaXuatBanDTO nxb){
        this(nxb.ma,nxb.ten,nxb.diachi);
    }
    
}
