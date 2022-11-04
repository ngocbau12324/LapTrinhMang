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
public class NhaCUngCapDTO {
    String id, ten_nha_cc;

    public NhaCUngCapDTO() {
    }

    public NhaCUngCapDTO(String id, String ten_nha_cc) {
        this.id = id;
        this.ten_nha_cc = ten_nha_cc;
    }

    public NhaCUngCapDTO(String ten_nha_cc) {
        this.ten_nha_cc = ten_nha_cc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen_nha_cc() {
        return ten_nha_cc;
    }

    public void setTen_nha_cc(String ten_nha_cc) {
        this.ten_nha_cc = ten_nha_cc;
    }

    @Override
    public String toString() {
        return "NhaCUngCapDTO{" + "id=" + id + ", ten_nha_cc=" + ten_nha_cc + '}';
    }
    
}
