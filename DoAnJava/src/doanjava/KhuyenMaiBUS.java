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
public class KhuyenMaiBUS {
    static ArrayList<KhuyenMaiDTO> danhSachKhuyenMai;
    public KhuyenMaiBUS(){};
    void docDanhSachKhuyenMai() throws ClassNotFoundException, SQLException, ParseException{
        KhuyenMaiDAO khuyenMaiDAO=new KhuyenMaiDAO();
        if(danhSachKhuyenMai==null) danhSachKhuyenMai=new ArrayList<KhuyenMaiDTO>();
        danhSachKhuyenMai=khuyenMaiDAO.docDanhSachKhuyenMai();
    }
    void them(KhuyenMaiDTO khuyenMaiDTO) throws ClassNotFoundException, SQLException{
        KhuyenMaiDAO khuyenMaiDAO=new KhuyenMaiDAO();
        khuyenMaiDAO.them(khuyenMaiDTO);
        danhSachKhuyenMai.add(khuyenMaiDTO);
    }
    void xoa(String id) throws ClassNotFoundException, SQLException, ParseException{
        KhuyenMaiDAO khuyenMaiDAO=new KhuyenMaiDAO();
        khuyenMaiDAO.xoa(id);
        docDanhSachKhuyenMai();
    }
    void sua(KhuyenMaiDTO khuyenMaiDTO) throws ClassNotFoundException, SQLException, ParseException{
        KhuyenMaiDAO khuyenMaiDAO=new KhuyenMaiDAO();
        khuyenMaiDAO.sua(khuyenMaiDTO);
        docDanhSachKhuyenMai();
    }
}
