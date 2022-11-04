/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import MYSQL.ConnecttoMSSQL;
import BUS.khachhangBUS;
import DTO.khachhangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e
 */
public class khachhangDAO 
{
    
    public ResultSet getData(String table) throws SQLException
    {
        ResultSet rs;
        //ResultSet rs;
        try
        {
        ConnecttoMSSQL Connect = new ConnecttoMSSQL();
        Connection conn = Connect.getConnectiontoSQL();
        Statement st = conn.createStatement();
        String sql = "select * from "+table+"";
        rs = st.executeQuery(sql);
        return rs;
        }
        catch(SQLException e)
        {
            return rs = null;
        }
    }
    public ResultSet getData(String table, int id) throws SQLException
    {
        ResultSet rs;
        //ResultSet rs;
        try
        {
        ConnecttoMSSQL Connect = new ConnecttoMSSQL();
        Connection conn = Connect.getConnectiontoSQL();
        Statement st = conn.createStatement();
        String sql = "select * from "+table+" where idkhachhang = "+id+"" ;
        rs = st.executeQuery(sql);
        return rs;
        }
        catch(SQLException e)
        {
            return rs = null;
        }
    }
    
//    public ResultSet getTK(String table, String gioitinh) throws SQLException
//    {
//        ResultSet rs;
//        //ResultSet rs;
//        try
//        {
//        ConnecttoMSSQL Connect = new ConnecttoMSSQL();
//        Connection conn = Connect.getConnectiontoSQL();
//        Statement st = conn.createStatement();
//        String sql = "select * from "+table+" where gioitinh='"+gioitinh+"'" ;
//        rs = st.executeQuery(sql);
//        System.out.println(rs.getString(1));
//        return rs;
//        }
//        catch(SQLException e)
//        {
//            return rs = null;
//        }
//    }
    
    public void Insert(khachhangDTO nv)
    {
        ConnecttoMSSQL conn = new ConnecttoMSSQL();
        Connection con = conn.getConnectiontoSQL();
        String sql = "insert into khachhang(idkhachhang,tenkhachhang,gioitinh,diachi,sdt) values (?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, nv.getId());
            pst.setString(2,nv.getName());
            pst.setString(3, nv.getGioitinh());
            pst.setString(4, nv.getDiachi());
            pst.setString(5, nv.getSdt());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(khachhangBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Edit(khachhangDTO nv)
    {
        ConnecttoMSSQL conn = new ConnecttoMSSQL();
        Connection con = conn.getConnectiontoSQL();
        String str[]=new String[]{nv.getName(),nv.getGioitinh(),nv.getDiachi(),nv.getSdt()};
        String sql = "update khachhang set tenkhachhang='" + str[0] + "',gioitinh='" + str[1] +
                "',diachi='" + str[2] + "',sdt='" + str[3] + "' where idkhachhang=" + nv.getId();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(khachhangBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Delete(int id) throws SQLException
    {
        String sql= "delete from khachhang where idkhachhang = ?";
        ConnecttoMSSQL conn = new ConnecttoMSSQL();
        Connection con = conn.getConnectiontoSQL();
        PreparedStatement pst = null;
        pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();
    }
    
    public static void main(String args[]){
        khachhangDTO kh = new khachhangDTO();
        khachhangDAO dao = new khachhangDAO();
        dao.Edit(kh);
    }
}
