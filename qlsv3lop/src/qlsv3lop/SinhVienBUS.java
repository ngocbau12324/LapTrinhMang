/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv3lop;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author NGOC BAU
 */
public class SinhVienBUS {
    static ArrayList<SinhVienDTO> dssv;

    public SinhVienBUS() {
    }
    void docDSSV() throws SQLException, ParseException{
        SinhVienDAO data=new SinhVienDAO();
        if(dssv==null) dssv=new ArrayList<SinhVienDTO>();
        dssv=data.docDSSV();
    }
    void them(SinhVienDTO sv) throws SQLException{
        //kiem tra du lieu hop le
        //kiem tra ma sinh vien duy nhat
        SinhVienDAO data=new SinhVienDAO();
        data.them(sv);
        dssv.add(sv);
    }
    SinhVienDTO timkiem(String mssv){
        SinhVienDTO sv=new SinhVienDTO();
        //duyet arr dssv;
        return sv; 
    }
}
