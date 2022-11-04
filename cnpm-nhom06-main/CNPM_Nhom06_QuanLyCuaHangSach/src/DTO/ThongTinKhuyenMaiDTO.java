/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author tiens
 */
public class ThongTinKhuyenMaiDTO {
    private String makm;
    private String masp;
    private String giamgia;
    private String qua;
    public ThongTinKhuyenMaiDTO(){
        
    }
    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(String giamgia) {
        this.giamgia = giamgia;
    }

    public String getQua() {
        return qua;
    }

    public void setQua(String qua) {
        this.qua = qua;
    }

    public ThongTinKhuyenMaiDTO(String makm, String masp, String giamgia, String qua) {
        this.makm = makm;
        this.masp = masp;
        this.giamgia = giamgia;
        this.qua = qua;
    }
    
    public ThongTinKhuyenMaiDTO(ThongTinKhuyenMaiDTO t){
        this(t.makm,t.masp,t.giamgia,t.qua);
    }
}
