/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import MYSQL.MyDataAccess;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author xenov
 */

public class NhanVienDAO {
	public NhanVienDAO() {}
	public ArrayList<NhanVienDTO> docNhanVien() throws Exception{
		ArrayList<NhanVienDTO> ds = new ArrayList<NhanVienDTO>();
                MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
		try {
			String qry = "select * from nhanvien";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				NhanVienDTO nv = new NhanVienDTO();
				nv.setMa(rs.getString(1));
				nv.setHo(rs.getString(2));
				nv.setTen(rs.getString(3));
				nv.setCa(rs.getString(4));
				nv.setNgaysinh(rs.getString(5));
				nv.setGioitinh(rs.getBoolean(6));
				nv.setLuong(rs.getInt(7));
				ds.add(nv);
			}
		}catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
		}
                finally{
                    my.close();
                }
		return ds;
	}
	
	public int them(NhanVienDTO nv) {
                if(isValidToAdd(nv.getMa())){
                    int res = 0;
                    try {
                        MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
			String qry = "Insert into nhanvien Value(";
			qry += "'" + nv.getMa() + "'";
			qry += ",'" + nv.getHo() + "'";
			qry += ",'" + nv.getTen() + "'";
			qry += ",'" + nv.getCa() + "'";
			qry += ",'" + nv.getNgaysinh() + "'";
			qry += "," + nv.isGioitinh() + "";
			qry += "," + nv.getLuong() + ")";
			res = my.executeUpdate(qry);
                        }
                        catch(Exception e) {
                                System.out.println(e);
                                JOptionPane.showMessageDialog(null,"Lỗi thêm vào Database");
                        }
                    return res;
                }else return 0;
		
	}
	public int xoa(String ma) {
            int res = 0;
		try {
			String qry = "delete from nhanvien where ma='" + ma + "'";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
            return res;
	}
	public int sua(NhanVienDTO nv) {
                int res = 0;
		try {
			String qry = "Update nhanvien set ";
			qry += "ho=" + "'" + nv.getHo() + "',";
			qry += "ten=" + "'" + nv.getTen() + "',";
			qry += "ca=" + "'" + nv.getCa() + "',";
			qry += "ngaysinh=" + "'" + nv.getNgaysinh() + "',";
			qry += "gioitinh=" + "" + nv.isGioitinh() + ",";
			qry += "luong=" + "" + nv.getLuong() + "";
			qry += " where ma='" + nv.getMa() + "'";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi sửa Database");
		}
                return res;
	}
        public void DeleteAll(){
            try {
			String qry = "delete from nhanvien";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                        my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
        }
        public boolean isValidToAdd(String ma){
            try{
                String qry = "select * from nhanvien where ma='" + ma + "'";
                MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                ResultSet rs = my.executeQuery(qry);
                if(rs.next()) return false;
                else return true;
            }catch(Exception e){}
            return true;
        }
        public Vector load(String str){
            MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
            Vector cbBox = new Vector();
            try{
                ResultSet rs = my.executeQuery("select * from " + str);
                while(rs.next()){
                       cbBox.add(rs.getString(1));
                }   
             }catch(Exception e){e.printStackTrace();}
            return cbBox;
        }
}
