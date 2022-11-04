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
public class SanPhamBUS {
    static ArrayList<SanPhamDTO> danhSachSanPham;
    public SanPhamBUS(){};
    void docDanhSachSanPham() throws ClassNotFoundException, SQLException, ParseException{
        SanPhamDAO sanPhamDAO=new SanPhamDAO();
        if(danhSachSanPham==null) danhSachSanPham=new ArrayList<SanPhamDTO>();
        danhSachSanPham=sanPhamDAO.docDanhSachSanPham();
    }
    void them(SanPhamDTO sanPhamDTO) throws ClassNotFoundException, SQLException{
        SanPhamDAO sanPhamDAO=new SanPhamDAO();
        sanPhamDAO.them(sanPhamDTO);
        danhSachSanPham.add(sanPhamDTO);
    }
    void xoa(String id) throws ClassNotFoundException, SQLException, ParseException{
        SanPhamDAO sanPhamDAO=new SanPhamDAO();
        sanPhamDAO.xoa(id);
        docDanhSachSanPham();
    }
    void sua(SanPhamDTO sanPhamDTO) throws ClassNotFoundException, SQLException, ParseException{
        SanPhamDAO sanPhamDAO=new SanPhamDAO();
        sanPhamDAO.sua(sanPhamDTO);
        docDanhSachSanPham();
    }
    SanPhamDTO timkiem(String ma){
        
        for(SanPhamDTO sanPham: SanPhamBUS.danhSachSanPham){
            if(sanPham.getMaSanPham().equalsIgnoreCase(ma)){
                return sanPham;
            }
        }
        return null;
    }
    ArrayList<SanPhamDTO> timkiemTen(String ten) throws ClassNotFoundException, SQLException{
        SanPhamDAO sanPhamDAO=new SanPhamDAO();
        return sanPhamDAO.timkiemTen(ten);
    }
    SanPhamDTO thongTinSanPham(String ma) throws ClassNotFoundException, SQLException{
        SanPhamDAO sanPhamDAO=new SanPhamDAO();
        return sanPhamDAO.thongTinSanPham(ma);
    }
    ArrayList<SanPhamDTO> gia1(String a) throws ClassNotFoundException, SQLException, ParseException{
        SanPhamBUS sanPhamBUS=new SanPhamBUS();
        ArrayList list=new ArrayList<SanPhamDTO>();
        sanPhamBUS.docDanhSachSanPham();
        int flag=0;
        for(SanPhamDTO sp: SanPhamBUS.danhSachSanPham){
            if(sp.getDonGia()>= Integer.parseInt(a)){
                list.add(sp);
                flag=1;
            }
        }
        if(flag==0) return null;
        else return list;
    }
    ArrayList<SanPhamDTO> gia2(String a) throws ClassNotFoundException, SQLException, ParseException{
        SanPhamBUS sanPhamBUS=new SanPhamBUS();
        ArrayList list=new ArrayList<SanPhamDTO>();
        sanPhamBUS.docDanhSachSanPham();
        int flag=0;
        for(SanPhamDTO sp: SanPhamBUS.danhSachSanPham){
            if(sp.getDonGia()<= Integer.parseInt(a)){
                list.add(sp);
                flag=1;
            }
        }
        if(flag==0) return null;
        else return list;
    }
    ArrayList<SanPhamDTO> gia1_2(String a, String b) throws ClassNotFoundException, SQLException, ParseException{
        SanPhamBUS sanPhamBUS=new SanPhamBUS();
        ArrayList list=new ArrayList<SanPhamDTO>();
        sanPhamBUS.docDanhSachSanPham();
        int flag=0;
        for(SanPhamDTO sp: SanPhamBUS.danhSachSanPham){
            if((sp.getDonGia()>= Integer.parseInt(a))&&(sp.getDonGia()<=Integer.parseInt(b))){
                list.add(sp);
                flag=1;
            }
        }
        if(flag==0) return null;
        else return list;
    }
    ArrayList<SanPhamDTO> timkiemtl(String ma) throws ClassNotFoundException, SQLException, ParseException{
        SanPhamBUS sanPhamBUS=new SanPhamBUS();
        ArrayList list=new ArrayList<SanPhamDTO>();
        sanPhamBUS.docDanhSachSanPham();
        int flag=0;
        for(SanPhamDTO sp: SanPhamBUS.danhSachSanPham){
            if((sp.getMaTheLoai().equals(ma))){
                list.add(sp);
                flag=1;
            }
        }
        if(flag==0) return null;
        else return list;
    }
    ArrayList<SanPhamDTO> timkiemtl_gia(String ma,int gia1,int gia2) throws ClassNotFoundException, SQLException, ParseException{
        SanPhamBUS sanPhamBUS=new SanPhamBUS();
        ArrayList list=new ArrayList<SanPhamDTO>();
        sanPhamBUS.docDanhSachSanPham();
        int flag=0;
        for(SanPhamDTO sp: SanPhamBUS.danhSachSanPham){
            if((sp.getMaTheLoai().equals(ma))&&(sp.getDonGia()>=gia1 && sp.getDonGia()<=gia2)){
                list.add(sp);
                flag=1;
            }
        }
        if(flag==0) return null;
        else return list;
    }
}
