/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author NGOC BAU
 */
public class ChiTietHDBUS {
    static ArrayList<ChiTietHDDTO> danhSachChiTietHD;
    static ArrayList<ChiTietHDDTO> danhSachChiTietHDByIdHD;
    public ChiTietHDBUS(){};
    void docDanhSachChiTietHD() throws ClassNotFoundException, SQLException, ParseException{
        ChiTietHDDAO chiTietHDDAO=new ChiTietHDDAO();
        if(danhSachChiTietHD==null) danhSachChiTietHD=new ArrayList<ChiTietHDDTO>();
        danhSachChiTietHD=chiTietHDDAO.docDanhSachChiTietHD();
    }
     void docDanhSachChiTietHDByIdHD(String id) throws ClassNotFoundException, SQLException, ParseException{
        ChiTietHDDAO chiTietHDDAO=new ChiTietHDDAO();
        if(danhSachChiTietHDByIdHD==null) danhSachChiTietHDByIdHD=new ArrayList<ChiTietHDDTO>();
        danhSachChiTietHDByIdHD=chiTietHDDAO.docDanhSachChiTietHDByIdHD(id);
    }
    void them(ChiTietHDDTO chiTietHDDTO) throws ClassNotFoundException, SQLException{
        ChiTietHDDAO chiTietHDDAO=new ChiTietHDDAO();
        chiTietHDDAO.them(chiTietHDDTO);
        danhSachChiTietHD.add(chiTietHDDTO);
    }
    
}
