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
public class NhaCungCapBUS {
    static ArrayList<NhaCUngCapDTO> danhSachNhaCungCap;
    public NhaCungCapBUS(){};
    void docDanhSachNhaCungCap() throws ClassNotFoundException, SQLException, ParseException{
        NhaCungCapDAO nhaCungCapDAO=new NhaCungCapDAO();
        if(danhSachNhaCungCap==null) danhSachNhaCungCap=new ArrayList<NhaCUngCapDTO>();
        danhSachNhaCungCap=nhaCungCapDAO.docDanhSachNhaCungCap();
    }
    void them(NhaCUngCapDTO nhaCUngCapDTO) throws ClassNotFoundException, SQLException{
        NhaCungCapDAO nhaCungCapDAO=new NhaCungCapDAO();
        nhaCungCapDAO.them(nhaCUngCapDTO);
        danhSachNhaCungCap.add(nhaCUngCapDTO);
    }
    void xoa(String id) throws ClassNotFoundException, SQLException, ParseException{
        NhaCungCapDAO nhaCungCapDAO=new NhaCungCapDAO();
        nhaCungCapDAO.xoa(id);
        docDanhSachNhaCungCap();
    }
    void sua(NhaCUngCapDTO nhaCUngCapDTO) throws ClassNotFoundException, SQLException, ParseException{
        NhaCungCapDAO nhaCungCapDAO=new NhaCungCapDAO();
        nhaCungCapDAO.sua(nhaCUngCapDTO);
        docDanhSachNhaCungCap();
    }
}
