/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import BUS.khachhangBUS;
import java.sql.Date;
import java.sql.SQLException;

public class khachhangDTO extends objectDTO
{
    String diachi;
    String gioitinh;
    String sdt;

    public khachhangDTO() {
        this("TpHCM","Nam","0347195404",2,"Phạm Bá Nguyên Trung");
    }
    public khachhangDTO(String diachi, String gioitinh, String sdt, int id, String name) {
        super(id, name);
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
    }
    public khachhangDTO(khachhangDTO kh){
        this(kh.diachi,kh.gioitinh,kh.sdt,kh.id,kh.name);
    }
//
//
//    @Override
//    public int getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public void setName(String name) {
//        this.name = name;
//    }


    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
