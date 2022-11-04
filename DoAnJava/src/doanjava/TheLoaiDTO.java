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
public class TheLoaiDTO {
    String maTheLoaiString,tenTheLoaiString;

    public TheLoaiDTO(String maTheLoaiString, String tenTheLoaiString) {
        this.maTheLoaiString = maTheLoaiString;
        this.tenTheLoaiString = tenTheLoaiString;
    }

    public TheLoaiDTO(String tenTheLoaiString) {
        this.tenTheLoaiString = tenTheLoaiString;
    }

    public TheLoaiDTO() {
    }

    public String getMaTheLoaiString() {
        return maTheLoaiString;
    }

    public void setMaTheLoaiString(String maTheLoaiString) {
        this.maTheLoaiString = maTheLoaiString;
    }

    public String getTenTheLoaiString() {
        return tenTheLoaiString;
    }

    public void setTenTheLoaiString(String tenTheLoaiString) {
        this.tenTheLoaiString = tenTheLoaiString;
    }

    @Override
    public String toString() {
        return "TheLoaiDTO{" + "maTheLoaiString=" + maTheLoaiString + ", tenTheLoaiString=" + tenTheLoaiString + '}';
    }
    
    
}
