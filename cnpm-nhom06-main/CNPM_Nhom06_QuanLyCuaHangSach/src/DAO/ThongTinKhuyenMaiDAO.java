/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MYSQL.MyDataAccess;
import DTO.ThongTinKhuyenMaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author tiens
 */
public class ThongTinKhuyenMaiDAO {
    public ThongTinKhuyenMaiDAO() {}
	public ArrayList<ThongTinKhuyenMaiDTO> docNhanVien() throws Exception{
		ArrayList<ThongTinKhuyenMaiDTO> ds = new ArrayList<ThongTinKhuyenMaiDTO>();
                MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
		try {
			String qry = "select * from thongtinkhuyenmai";
			                 ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				ThongTinKhuyenMaiDTO nv = new ThongTinKhuyenMaiDTO();
				nv.setMakm(rs.getString(1));
				nv.setMasp(rs.getString(2));
				nv.setGiamgia(rs.getString(3));
				nv.setQua(rs.getString(4));
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
	
	public int them(ThongTinKhuyenMaiDTO nv) {
                if(isValidToAdd(nv.getMakm(),nv.getMasp())){
                    int res = 0;
                    try {
                        MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
			String qry = "Insert into thongtinkhuyenmai Value(";
			qry += "'" + nv.getMakm() + "'";
			qry += ",'" + nv.getMasp() + "'";
			qry += ",'" + nv.getGiamgia() + "'";
			qry += ",'" + nv.getQua() + "')";
			res = my.executeUpdate(qry);
                        }
                        catch(Exception e) {
                                System.out.println(e);
                                JOptionPane.showMessageDialog(null,"Lỗi thêm vào Database");
                        }
                    return res;
                }else return 0;
		
	}
	public int xoa(String makm,String masp) {
            int res = 0;
		try {
			String qry = "delete from thongtinkhuyenmai where makm='" + makm + "' && masp='" + masp + "'";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                        res = my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
            return res;
	}
	public int sua(ThongTinKhuyenMaiDTO nv) {
                int res = 0;
		try {
			String qry = "Update thongtinkhuyenmai set ";
			qry += "giamgia=" + "'" + nv.getGiamgia() + "',";
			qry += "qua=" + "'" + nv.getQua() + "'";
			qry += " where makm='" + nv.getMakm() + "' && masp='" + nv.getMasp() + "'";
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
			String qry = "delete from thongtinkhuyenmai";
			MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                        my.executeUpdate(qry);
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database");
		}
        }
        public boolean isValidToAdd(String makm,String masp){
            try{
                String qry = "select * from thongtinkhuyenmai where makm='" + makm + "' && masp='" + masp + "'";
                MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
                ResultSet rs = my.executeQuery(qry);
                if(rs.next()) return false;
                else return true;
            }catch(Exception e){}
            return true;
        }
        public Vector load(String str) throws Exception{
            MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
            String qry = "select * from " + str;
            Vector res = new Vector();
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                res.add(rs.getString(1));
            }
            return res;
        }
        
}
