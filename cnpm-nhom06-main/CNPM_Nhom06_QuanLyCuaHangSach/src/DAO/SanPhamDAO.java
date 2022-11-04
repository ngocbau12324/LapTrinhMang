/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MYSQL.MyDataAccess;
import DTO.SanPhamDTO;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author tiens
 */
public class SanPhamDAO 
{
    public SanPhamDAO() {}
	public ArrayList<SanPhamDTO> docSanPham() throws Exception
	{
		ArrayList<SanPhamDTO> ds = new ArrayList<SanPhamDTO>();
		MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
		try 
		{
			String qry = "select * from sanpham";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) 
			{
				SanPhamDTO sp = new SanPhamDTO();
				sp.setMa(rs.getString(1));
				sp.setLoai(rs.getString(2));
				sp.setTen(rs.getString(3));
				sp.setDongia(rs.getInt(4));
				sp.setSoluong(rs.getInt(5));
				sp.setGhichu(rs.getString(6));
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
	public int them(SanPhamDTO sp) 
	{
		if(isValidToAdd(sp.getMa()))
		{
			int res = 0;
            try 
            {
            	MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
            	String qry = "Insert into sanpham Value(";
            	qry += "'" + sp.getMa() + "'";
            	qry += ",'" + sp.getLoai() + "'";
            	qry += ",'" + sp.getTen() + "'";
            	qry += "," + sp.getDongia() + "";
            	qry += "," + sp.getSoluong() + "";
            	qry += ",'" + sp.getGhichu() + "')";
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
			String qry = "delete from sanpham where ma='" + ma + "'";
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
	public int sua(SanPhamDTO sp) 
	{
		int res = 0;
		try 
		{
			String qry = "Update sanpham set ";
			qry += "loai=" + "'" + sp.getLoai() + "',";
			qry += "ten=" + "'" + sp.getTen() + "',";
			qry += "dongia=" + "" + sp.getDongia() + ",";
			qry += "soluong=" + "" + sp.getSoluong() + ",";
			qry += "ghichu=" + "'" + sp.getGhichu() + "'";
			qry += " where ma='" + sp.getMa() + "'";
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
			String qry = "delete from sanpham";
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
    		String qry = "select * from sanpham where ma='" + ma + "'";
    		MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
    		ResultSet rs = my.executeQuery(qry);
            if(rs.next()) return false;
            else return true;
        }
    	catch(Exception e) {}
        return true;
    }
    public int ThemBotSoLuongSanPham(String ma, int value){
        MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
        try{
            ResultSet rs = my.executeQuery("select * from sanpham where ma='" + ma +"'");
            rs.next();
            String giatri = rs.getString("soluong");
            value = Integer.parseInt(giatri) + value;
            int n = my.executeUpdate("update sanpham set soluong=" + value +" where ma='" + ma +"'");
            return n;
        }catch(Exception e){}
        return 0;
    }
    public static void main(String args[]){
        SanPhamDAO ct = new SanPhamDAO();
        ct.ThemBotSoLuongSanPham("SP003", 15);
    }
}
