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
public class NhanVienBUS {
    static ArrayList<NhanVienDTO> danhSachNhanVien;
    public NhanVienBUS(){};
    void docDanhSachNhanVien() throws ClassNotFoundException, SQLException, ParseException{
        NhanVienDAO nhanVienDAO=new NhanVienDAO();
        if(danhSachNhanVien==null) danhSachNhanVien=new ArrayList<NhanVienDTO>();
        danhSachNhanVien=nhanVienDAO.docDanhSachNhanVien();
    }
    void them(NhanVienDTO nhanVienDTO) throws ClassNotFoundException, SQLException{
        NhanVienDAO nhanVienDAO=new NhanVienDAO();
        nhanVienDAO.them(nhanVienDTO);
        danhSachNhanVien.add(nhanVienDTO);
    }
    void xoa(String id) throws ClassNotFoundException, SQLException, ParseException{
        NhanVienDAO nhanVienDAO=new NhanVienDAO();
        nhanVienDAO.xoa(id);
        docDanhSachNhanVien();
    }
    void sua(NhanVienDTO nhanVienDTO) throws ClassNotFoundException, SQLException, ParseException{
        NhanVienDAO nhanVienDAO=new NhanVienDAO();
        nhanVienDAO.sua(nhanVienDTO);
        docDanhSachNhanVien();
    }
    NhanVienDTO timkiem(String ma){
        NhanVienDTO nhanVienDTO=new NhanVienDTO();
        for(NhanVienDTO nhanVien: NhanVienBUS.danhSachNhanVien){
            if(nhanVien.getMaNhanVien().equalsIgnoreCase(ma)){
//                khachHangDTO.setMaKhachHang(khachHang.getMaKhachHang());
//                khachHangDTO.setHo(khachHang.getHo());
//                khachHangDTO.setTen(khachHang.getTen());
//                khachHangDTO.setNgaySinhDate(khachHang.getNgaySinhDate());
//                khachHangDTO.setDiaChiString(khachHang.getDiaChiString());
//                khachHangDTO.setSoDienThoai(khachHang.getSoDienThoai());
//                khachHangDTO.setEmail(khachHang.getEmail());
                return nhanVien;
            }
        }
        return null;
    }
    
    ArrayList<NhanVienDTO> timKiemTen(String ten) throws ClassNotFoundException, SQLException, ParseException{
        NhanVienDAO nhanVienDAO=new NhanVienDAO();
        return nhanVienDAO.timkiemTen(ten);
    }
    ArrayList<NhanVienDTO> timKiemSdt(String sdt) throws ClassNotFoundException, SQLException, ParseException{
        NhanVienDAO nhanVienDAO=new NhanVienDAO();
        return nhanVienDAO.timkiemSdt(sdt);
    }
    
}
