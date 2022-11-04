/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietHoaDonDTO;
import MYSQL.MyDataAccess;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author vosin
 */
public class ChiTietHoaDonDAO {
    
    public ChiTietHoaDonDAO(){}
    public ArrayList<ChiTietHoaDonDTO> docDuLieu() throws Exception{
		ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<ChiTietHoaDonDTO>();
                MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
		try {
			String qry = "select * from chitiethoadon";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO();
				ct.setMahd(rs.getString(1));
				ct.setMasp(rs.getString(2));
				ct.setDongia(Integer.parseInt(rs.getString(3)));
				ct.setSoluong(Integer.parseInt(rs.getString(4)));
                                ct.setMaKhuyenmai(rs.getString(5));
				ct.setThanhtien(Integer.parseInt(rs.getString(6)));
				ds.add(ct);
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
    
    //-------------------------------------------------------------------
    public int them(ChiTietHoaDonDTO ct) {
                if(isValidToAdd(ct.getMahd(),ct.getMasp())){
                    int res = 0;
                    try {
                            MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                            String qry = "Insert into chitiethoadon Value(";
                            qry += "'" + ct.getMahd() + "'";
                            qry += ",'" + ct.getMasp() + "'";
                            qry += "," + ct.getDongia() + "";
                            qry += "," + ct.getSoluong() + "";
                            qry += ",'" +ct.getMaKhuyenmai() + "'";
                            qry += "," + ct.getThanhtien() + ")";
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
			String qry = "delete from chitiethoadon where mahd='" + mahd + "' && masp='" + masp + "'";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
            return res;
	}
	public int sua(ChiTietHoaDonDTO ct) {
                int res = 0;
		try {
			String qry = "Update chitiethoadon set ";
			qry += "dongia=" + "" + ct.getDongia() + ",";
			qry += "soluong=" + "" + ct.getSoluong() + ",";
                        qry += "maKhuyenmai=" + "" + ct.getMaKhuyenmai() + ",";
			qry += "thanhtien=" + "" + ct.getThanhtien() + "";
			qry += " where mahd='" + ct.getMahd() + "' && masp='" + ct.getMasp()+"'";
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
			String qry = "delete from chitiethoadon";
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
                String qry = "select * from chitiethoadon where mahd='" + mahd + "' && masp='" + masp + "'";
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
             String qry = "select * from " + table + " where masp='" + ma +"'";
             ResultSet rs = my.executeQuery(qry);
             rs.next();
             String res = rs.getString("dongia");
             return res;
        }
        public String getDonGia(String table, String ma) throws Exception{
             MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
             String qry = "select * from " + table + " where ma='" + ma +"'";
             ResultSet rs = my.executeQuery(qry);
             rs.next();
             String res = rs.getString("dongia");
             return res;
        }
        
        public String getgiamgia(String table, String ma, String makm) throws Exception{
             MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
             String qry = "select * from " + table + " where masp='" + ma +"' && makm='" +makm + "'";
             ResultSet rs = my.executeQuery(qry);
             ;
             if(!rs.next()) return "no";
             String res = rs.getString("giamgia");
             return res;
        }
    
}
