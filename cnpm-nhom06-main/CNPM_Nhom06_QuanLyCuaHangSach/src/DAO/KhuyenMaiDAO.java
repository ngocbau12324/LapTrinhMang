/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.KhuyenMaiDTO;
import MYSQL.MyDataAccess;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author tiens
 */
public class KhuyenMaiDAO 
{
    public KhuyenMaiDAO() {}
	public ArrayList<KhuyenMaiDTO> docKhuyenMai() throws Exception
	{
		ArrayList<KhuyenMaiDTO> ds = new ArrayList<KhuyenMaiDTO>();
		MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
		try 
		{
			String qry = "select * from khuyenmai";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) 
			{
				KhuyenMaiDTO sp = new KhuyenMaiDTO();
				sp.setMa(rs.getString(1));				
				sp.setNgaybd(rs.getString(2));
				sp.setNgaykt(rs.getString(3));
                                sp.setMota(rs.getString(4));
				ds.add(sp);
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
		}
                
		finally
		{
			my.close();
        }
		return ds;
	}
	public int them(KhuyenMaiDTO km) 
	{
		if(isValidToAdd(km.getMa()))
		{
			int res = 0;
            try 
            {
            	MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
            	String qry = "Insert into khuyenmai Value(";
            	qry += "'" + km.getMa() + "'";           	
            	qry += ",'" + km.getNgaybd() + "'";
            	qry += ",'" + km.getNgaykt() + "'";
                qry += ",'" + km.getMota() + "')";
            	res = my.executeUpdate(qry);
            }
            catch(Exception e) 
            {
            	System.out.println(e);
                JOptionPane.showMessageDialog(null,"Lỗi thêm vào Database");
            }
            return res;
         }
		else return 0;
	}
	public int xoa(String ma) 
	{
        int res = 0;
		try 
		{
			String qry = "delete from khuyenmai where ma='" + ma + "'";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
			res = my.executeUpdate(qry);
		}
		catch(Exception e) 
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
        return res;
	}
	public int sua(KhuyenMaiDTO km) 
	{
		int res = 0;
		try 
		{
			String qry = "Update khuyenmai set ";
			qry += "ngaybd=" + "'" + km.getNgaybd() + "',";
			qry += "ngaykt=" + "'" + km.getNgaykt() + "',";
                        qry += "mota=" + "'" + km.getMota() + "'";
			qry += " where ma='" + km.getMa() + "'";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
			res = my.executeUpdate(qry);
		}
		catch(Exception e) 
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi sửa Database");
		}
        return res;
	}
    public void DeleteAll()
    {
    	try 
    	{
			String qry = "delete from khuyenmai";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
            my.executeUpdate(qry);
		}
		catch(Exception e) 
    	{
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
    }
    public boolean isValidToAdd(String ma)
    {
    	try
    	{
    		String qry = "select * from khuyenmai where ma='" + ma + "'";
    		      MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
    		ResultSet rs = my.executeQuery(qry);
            if(rs.next()) return false;
            else return true;
        }
    	catch(Exception e) {}
        return true;
    }
}
