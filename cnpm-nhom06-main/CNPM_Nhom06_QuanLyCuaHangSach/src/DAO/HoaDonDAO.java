/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;
import MYSQL.MyDataAccess;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author vosin
 */
public class HoaDonDAO {
    public HoaDonDAO(){}
    public ArrayList<HoaDonDTO> docDuLieu() throws Exception{
        ArrayList<HoaDonDTO> ds = new ArrayList<HoaDonDTO>();
        MyDataAccess data = new MyDataAccess("localhost","root","","qlda");
        try{
            ResultSet rs = data.executeQuery("select * from hoadon");
            while(rs.next()){
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMahd(rs.getString(1));
                hd.setManv(rs.getString(2));
                hd.setMakh(rs.getString(3));
                hd.setNgayxuat(rs.getString(4));
                hd.setTongchi(rs.getInt(5));
                hd.setGhichu(rs.getString(6));
                ds.add(hd);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi kết nối Database");
        }
        finally{
            data.close();
        }
        return ds;
    }
    public int them(HoaDonDTO hd) throws Exception{
        if(!isValidToAdd(hd.getMahd())){
            JOptionPane.showMessageDialog(null, "Mã tồn tại. Thêm thất bại");
            return 0;
        }
        MyDataAccess data = new MyDataAccess("localhost","root","","qlda");
        String qry = "insert into hoadon value(";
        qry += "'" + hd.getMahd() + "',";
        qry += "'" + hd.getManv() + "',";
        qry += "'" + hd.getMakh() + "',";
        qry += "'" + hd.getNgayxuat() + "',";
        qry += "" + hd.getTongchi()+ ",";
        qry += "'" + hd.getGhichu()+ "')";
        int result = 0;
        try{
            result = data.executeUpdate(qry);
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi thêm database");
        }
        return result;
    }
    public int sua(HoaDonDTO hd){
        try{
            MyDataAccess data = new MyDataAccess("localhost","root","","qlda");
            String qry = "update hoadon set ";
            qry += "manv='" + hd.getManv() + "',";
            qry += "makh='" + hd.getMakh() + "',";
            qry += "ngayxuat='" + hd.getNgayxuat() + "',";
            qry += "tongchi=" + hd.getTongchi()+ ",";
            qry += "ghichu='" + hd.getGhichu()+ "'";
            qry += " where mahd='" + hd.getMahd() +"'";
            int result = 0;
            try{
                result = data.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Lỗi sửa Database");
            }
            return result;
        }catch(Exception e){}
        return 1;
    }
    public int xoa(HoaDonDTO hd){
        MyDataAccess data = new MyDataAccess("localhost","root","","qlda");
        String qry = "delete from hoadon where mahd='" + hd.getMahd()  + "'";
        int result = 0;
        try{
            result = data.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi sửa Database");
        }
        return result;
    }
    public boolean isValidToAdd(String ma) throws Exception{
        MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
        ResultSet rs = my.executeQuery("select * from hoadon where mahd='" + ma + "'");
        return (rs.next()?false:true);
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
