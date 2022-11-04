/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhaXuatBanDTO;
import MYSQL.MyDataAccess;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author xenov
 */
public class NhaXuatBanDAO {
    public NhaXuatBanDAO() {}
	public ArrayList<NhaXuatBanDTO> docDuLieu() throws Exception{
		ArrayList<NhaXuatBanDTO> ds = new ArrayList<NhaXuatBanDTO>();
                MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
		try {
			String qry = "select * from nhaxuatban";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				NhaXuatBanDTO nv = new NhaXuatBanDTO();
				nv.setMa(rs.getString(1));
				nv.setTen(rs.getString(2));
				nv.setDiaChi(rs.getString(3));
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
	
	public int them(NhaXuatBanDTO nv) {
                if(isValidToAdd(nv.getMa())){
                    int res = 0;
                    try {
                        MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
			String qry = "Insert into nhaxuatban Value(";
			qry += "'" + nv.getMa() + "'";
			qry += ",'" + nv.getTen() + "'";
			qry += ",'" + nv.getDiaChi() + "')";
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
			String qry = "delete from nhaxuatban where ma='" + ma + "'";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
            return res;
	}
	public int sua(NhaXuatBanDTO nv) {
                int res = 0;
		try {
			String qry = "Update nhaxuatban set ";
			qry += "ten=" + "'" + nv.getTen() + "',";
			qry += "diachi=" + "'" + nv.getDiaChi() + "'";
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
			String qry = "delete from nhaxuatban";
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
                String qry = "select * from nhaxuatban where ma='" + ma + "'";
                MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                ResultSet rs = my.executeQuery(qry);
                if(rs.next()) return false;
                else return true;
            }catch(Exception e){}
            return true;
        }
}
