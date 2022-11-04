/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.khachhangDAO;
import DTO.khachhangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class khachhangBUS 
{
    public static ArrayList<khachhangDTO> ds;
    public ArrayList<khachhangDTO> getAllKhachHang() throws SQLException
    {
        khachhangDAO khachhang = new khachhangDAO();
        ResultSet rs = khachhang.getData("khachhang");
        ArrayList<khachhangDTO> list = new ArrayList<>();
        while (rs.next()) 
        {
            khachhangDTO kh = new khachhangDTO(rs.getString("diachi"), rs.getString("gioitinh"), rs.getString("sdt"), rs.getInt("idkhachhang"), rs.getString("tenkhachhang"));
            list.add(kh);
        }
        return list;
    }
    
    public khachhangDTO getKhachHangByID(int id) throws SQLException
    {
        khachhangDAO khachhang = new khachhangDAO();
        ResultSet rs = khachhang.getData("khachhang", id);
        if (rs.next()) 
        {
            khachhangDTO kh = new khachhangDTO(rs.getString("diachi"), rs.getString("gioitinh"), rs.getString("sdt"), rs.getInt("idkhachhang"), rs.getString("tenkhachhang"));
            return kh;
        }
        return null;
    }
//    public khachhangDTO getKhachHangByTK(String gioitinh) throws SQLException
//    {
//        khachhangDAO khachhang = new khachhangDAO();
//        ResultSet rs = khachhang.getTK("khachhang", gioitinh);
//        if (rs.next()) 
//        {
//            khachhangDTO kh = new khachhangDTO(rs.getString("diachi"), rs.getString("gioitinh"), rs.getString("sdt"), rs.getInt("idkhachhang"), rs.getString("tenkhachhang"));
//            return kh;
//        }
//        return null;
//    }
    public ArrayList<khachhangDTO> getKhachHangByTK(String gioitinh,ArrayList<khachhangDTO> list) throws SQLException
    {
        if(gioitinh.indexOf("Tất cả")!=-1) return list;
        ArrayList<khachhangDTO> kh = new ArrayList<khachhangDTO>();
        for(khachhangDTO dto:list){
            if(dto.getGioitinh().toLowerCase().equals(gioitinh.toLowerCase()))
                kh.add(new khachhangDTO(dto));
        }
        return kh;
    }
    public void Insert(khachhangDTO kh) throws SQLException
    {
        khachhangDAO NVD = new khachhangDAO();
        NVD.Insert(kh);
    }
    
    public void Edit(khachhangDTO kh)
    {
        khachhangDAO NVD = new khachhangDAO();
        NVD.Edit(kh);
    }
    public void Delete(int id) throws SQLException
    {
        khachhangDAO NVD = new khachhangDAO();
        NVD.Delete(id);
    }
}
