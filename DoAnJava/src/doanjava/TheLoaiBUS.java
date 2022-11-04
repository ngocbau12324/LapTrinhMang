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
public class TheLoaiBUS {
    static ArrayList<TheLoaiDTO> danhSachTheLoai;
    public TheLoaiBUS(){};
    void docDanhSachTheLoai() throws ClassNotFoundException, SQLException, ParseException{
        TheLoaiDAO theLoaiDAO=new TheLoaiDAO();
        if(danhSachTheLoai==null) danhSachTheLoai=new ArrayList<TheLoaiDTO>();
        danhSachTheLoai=theLoaiDAO.docDanhSachTheLoai();
    }
    void them(TheLoaiDTO theLoaiDTO) throws ClassNotFoundException, SQLException{
        TheLoaiDAO theLoaiDAO=new TheLoaiDAO();
        theLoaiDAO.them(theLoaiDTO);
        danhSachTheLoai.add(theLoaiDTO);
    }
    void xoa(String id) throws ClassNotFoundException, SQLException, ParseException{
        TheLoaiDAO theLoaiDAO=new TheLoaiDAO();
        theLoaiDAO.xoa(id);
        docDanhSachTheLoai();
    }
    void sua(TheLoaiDTO theLoaiDTO) throws ClassNotFoundException, SQLException, ParseException{
        TheLoaiDAO theLoaiDAO=new TheLoaiDAO();
        theLoaiDAO.sua(theLoaiDTO);
        docDanhSachTheLoai();
    }
    TheLoaiDTO timkiem(String ma) throws ClassNotFoundException, SQLException, ParseException{
        TheLoaiBUS theLoaiBUS=new TheLoaiBUS();
        theLoaiBUS.docDanhSachTheLoai();
        for(TheLoaiDTO theloai: TheLoaiBUS.danhSachTheLoai){
            if(theloai.getMaTheLoaiString().equalsIgnoreCase(ma)){
                return theloai;
            }
        }
        return null;
    }
    ArrayList<TheLoaiDTO> timkiemTen(String ten) throws ClassNotFoundException, SQLException{
        TheLoaiDAO theLoaiDAO=new TheLoaiDAO();
        return theLoaiDAO.timkiemTen(ten);
    }
    TheLoaiDTO thongTinTheLoai(String ma) throws ClassNotFoundException, SQLException{
        TheLoaiDAO theLoaiDAO=new TheLoaiDAO();
        return theLoaiDAO.thongTinTheLoai(ma);
    }
    
}
