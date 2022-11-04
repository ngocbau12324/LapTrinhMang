/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhapDTO;
import MYSQL.MyDataAccess;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author xenov
 */
public class ChiTietPhieuNhapDAO {
    public ChiTietPhieuNhapDAO(){}
    public ArrayList<ChiTietPhieuNhapDTO> docDuLieu() throws Exception{
		ArrayList<ChiTietPhieuNhapDTO> ds = new ArrayList<ChiTietPhieuNhapDTO>();
                MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
		try {
			String qry = "select * from chitietphieunhap";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				ChiTietPhieuNhapDTO nv = new ChiTietPhieuNhapDTO();
				nv.setMahd(rs.getString(1));
				nv.setMasp(rs.getString(2));
				nv.setDongia(Integer.parseInt(rs.getString(3)));
				nv.setSoluong(Integer.parseInt(rs.getString(4)));
				nv.setThanhtien(Integer.parseInt(rs.getString(5)));
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
	
	public int them(ChiTietPhieuNhapDTO nv) {
                if(isValidToAdd(nv.getMahd(),nv.getMasp())){
                    int res = 0;
                    try {
                            MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                            String qry = "Insert into chitietphieunhap Value(";
                            qry += "'" + nv.getMahd() + "'";
                            qry += ",'" + nv.getMasp() + "'";
                            qry += "," + nv.getDongia() + "";
                            qry += "," + nv.getSoluong() + "";
                            qry += "," + nv.getThanhtien() + ")";
                            res = my.executeUpdate(qry);
                        }
                        catch(Exception e) {
                                System.out.println(e);
                                JOptionPane.showMessageDialog(null,"Lỗi thêm vào Database");
                        }
                    return res;
                }else return 0;
		
	}
	public int xoa(String mahd,String masp) {
            int res = 0;
		try {
			String qry = "delete from chitietphieunhap where mahd='" + mahd + "' && masp='" + masp + "'";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
            return res;
	}
	public int sua(ChiTietPhieuNhapDTO nv) {
                int res = 0;
		try {
			String qry = "Update chitietphieunhap set ";
			qry += "dongia=" + "" + nv.getDongia() + ",";
			qry += "soluong=" + "" + nv.getSoluong() + ",";
			qry += "thanhtien=" + "" + nv.getThanhtien() + "";
			qry += " where mahd='" + nv.getMahd() + "' && masp='" + nv.getMasp()+"'";
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
			String qry = "delete from chitietphieunhap";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                        my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
        }
        public boolean isValidToAdd(String mahd,String masp){
            try{
                String qry = "select * from chitietphieunhap where mahd='" + mahd + "' && masp='" + masp + "'";
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
        public String get(String table, String ma) throws Exception{
             MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
             String qry = "select * from " + table + " where ma='" + ma +"'";
             ResultSet rs = my.executeQuery(qry);
             rs.next();
             String res = rs.getString("dongia");
             return res;
        }
      
}
