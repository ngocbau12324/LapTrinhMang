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
public class KhachHangBUS {
    static ArrayList<KhachHangDTO> danhSachKhachHang;
    public KhachHangBUS(){};
    void docDanhSachKhachHang() throws ClassNotFoundException, SQLException, ParseException{
        KhachHangDAO khachHangDAO=new KhachHangDAO();
        if(danhSachKhachHang==null) danhSachKhachHang=new ArrayList<KhachHangDTO>();
        danhSachKhachHang=khachHangDAO.docDanhSachKhachHang();
    }
    void them(KhachHangDTO khachHangDTO) throws ClassNotFoundException, SQLException{
        KhachHangDAO khachHangDAO=new KhachHangDAO();
        khachHangDAO.them(khachHangDTO);
        danhSachKhachHang.add(khachHangDTO);
    }
    void xoa(String id) throws ClassNotFoundException, SQLException, ParseException{
        KhachHangDAO khachHangDAO=new KhachHangDAO();
        khachHangDAO.xoa(id);
        docDanhSachKhachHang();
    }
    void sua(KhachHangDTO khachHangDTO) throws ClassNotFoundException, SQLException, ParseException{
        KhachHangDAO khachHangDAO=new KhachHangDAO();
        khachHangDAO.sua(khachHangDTO);
        docDanhSachKhachHang();
    }
    KhachHangDTO timkiem(String ma){
        KhachHangDTO khachHangDTO=new KhachHangDTO();
        for(KhachHangDTO khachHang: KhachHangBUS.danhSachKhachHang){
            if(khachHang.getMaKhachHang().equalsIgnoreCase(ma)){
//                khachHangDTO.setMaKhachHang(khachHang.getMaKhachHang());
//                khachHangDTO.setHo(khachHang.getHo());
//                khachHangDTO.setTen(khachHang.getTen());
//                khachHangDTO.setNgaySinhDate(khachHang.getNgaySinhDate());
//                khachHangDTO.setDiaChiString(khachHang.getDiaChiString());
//                khachHangDTO.setSoDienThoai(khachHang.getSoDienThoai());
//                khachHangDTO.setEmail(khachHang.getEmail());
                return khachHang;
            }
        }
        return null;
    }
    ArrayList<KhachHangDTO> timKiemTen(String ten) throws ClassNotFoundException, SQLException, ParseException{
        KhachHangDAO khachHangDAO=new KhachHangDAO();
        return khachHangDAO.timkiemTen(ten);
    }
    ArrayList<KhachHangDTO> timKiemSdt(String sdt) throws ClassNotFoundException, SQLException, ParseException{
        KhachHangDAO khachHangDAO=new KhachHangDAO();
        return khachHangDAO.timkiemSdt(sdt);
    }
}
