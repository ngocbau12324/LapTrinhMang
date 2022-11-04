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
public class HoaDonBUS {
    static ArrayList<HoaDonDTO> danhSachHoaDon;
    public HoaDonBUS(){};
    void docDanhSachHoaDon() throws ClassNotFoundException, SQLException, ParseException{
        HoaDonDAO hoaDonDAO=new HoaDonDAO();
        if(danhSachHoaDon==null) danhSachHoaDon=new ArrayList<HoaDonDTO>();
        danhSachHoaDon=hoaDonDAO.docDanhSachHoaDon();
    }
    void them(HoaDonDTO hoaDonDTO) throws ClassNotFoundException, SQLException{
        HoaDonDAO hoaDonDAO=new HoaDonDAO();
        hoaDonDAO.them(hoaDonDTO);
        danhSachHoaDon.add(hoaDonDTO);
    }
    void them1(HoaDonDTO hoaDonDTO) throws ClassNotFoundException, SQLException{
        HoaDonDAO hoaDonDAO=new HoaDonDAO();
        hoaDonDAO.them1(hoaDonDTO);
        danhSachHoaDon.add(hoaDonDTO);
    }
    void xoa(String id) throws ClassNotFoundException, SQLException, ParseException{
        HoaDonDAO hoaDonDAO=new HoaDonDAO();
        hoaDonDAO.xoa(id);
        docDanhSachHoaDon();
    }
    
    
}
