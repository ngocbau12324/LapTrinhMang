/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhapDTO;
import MYSQL.MyDataAccess;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author xenov
 */
public class PhieuNhapDAO {
    public PhieuNhapDAO(){}
    public ArrayList<PhieuNhapDTO> docDuLieu() throws Exception{
        ArrayList<PhieuNhapDTO> ds = new ArrayList<PhieuNhapDTO>();
        MyDataAccess data = new MyDataAccess("localhost","root","","qlda");
        try{
            ResultSet rs = data.executeQuery("select * from phieunhap");
            while(rs.next()){
                PhieuNhapDTO hd = new PhieuNhapDTO();
                hd.setMahd(rs.getString(1));
                hd.setManv(rs.getString(2));
                hd.setMancc(rs.getString(3));
                hd.setNgaynhap(rs.getString(4));
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
    public int them(PhieuNhapDTO hd) throws Exception{
        if(!isValidToAdd(hd.getMahd())){
            JOptionPane.showMessageDialog(null, "Mã tồn tại. Thêm thất bại");
            return 0;
        }
        MyDataAccess data = new MyDataAccess("localhost","root","","qlda");
        String qry = "insert into phieunhap value(";
        qry += "'" + hd.getMahd() + "',";
        qry += "'" + hd.getManv() + "',";
        qry += "'" + hd.getMancc() + "',";
        qry += "'" + hd.getNgaynhap() + "',";
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
    public int sua(PhieuNhapDTO hd){
        try{
            MyDataAccess data = new MyDataAccess("localhost","root","","qlda");
            String qry = "update phieunhap set ";
            qry += "manv='" + hd.getManv() + "',";
            qry += "mancc='" + hd.getMancc() + "',";
            qry += "ngaynhap='" + hd.getNgaynhap() + "',";
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
    public int xoa(PhieuNhapDTO hd){
        MyDataAccess data = new MyDataAccess("localhost","root","","qlda");
        String qry = "delete from phieunhap where mahd='" + hd.getMahd()  + "'";
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
        ResultSet rs = my.executeQuery("select * from phieunhap where mahd='" + ma + "'");
        return (rs.next()?false:true);
    }
    public int setTongChi(String ma, int value) throws Exception{
        MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
        String qry = "update phieunhap set tongchi=" + value + " where mahd='" + ma + "'";
        int res = my.executeUpdate(qry);
        return res;
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
    public static void main(String args[]) throws Exception{
        PhieuNhapDAO hd = new PhieuNhapDAO();
        hd.setTongChi("PN001",65213);
    }
}
