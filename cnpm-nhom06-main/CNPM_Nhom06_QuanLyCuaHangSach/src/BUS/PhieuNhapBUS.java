/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author xenov
 */
public class PhieuNhapBUS {
    public static ArrayList<PhieuNhapDTO> ds;
    public PhieuNhapBUS(){}
    public void docDuLieu() throws Exception{
        PhieuNhapDAO data = new PhieuNhapDAO();
        if(ds == null){
            ds = data.docDuLieu();
        }
    }
    public int them(PhieuNhapDTO hd) throws Exception{
        PhieuNhapDAO data = new PhieuNhapDAO();
        int result = data.them(hd);
        if(result == 1){
            ds.add(hd);
        }
        return result;
    }
    public int sua(PhieuNhapDTO hd, int i) throws Exception{
        PhieuNhapDAO data = new PhieuNhapDAO();
        int result = data.sua(hd);
        if(result == 1){
            ds.set(i,hd);
        }
        return result;
    }
    public int xoa(int i){
        PhieuNhapDAO data = new PhieuNhapDAO();
        int result = data.xoa(ds.get(i));
        if(result == 1){
            ds.remove(i);
        }
        return result;
    }
    public Vector load(String str){
        PhieuNhapDAO data = new PhieuNhapDAO();
        return data.load(str);
        
    }
    public int setTongChi(String ma,int value) throws Exception{
        PhieuNhapDAO hd = new PhieuNhapDAO();
        int n = hd.setTongChi(ma, value);
        return n;
    }
    public ArrayList<PhieuNhapDTO> timKiem(String ma){
        ArrayList<PhieuNhapDTO> dsReturn = new ArrayList<PhieuNhapDTO>();
        for(PhieuNhapDTO hd:ds){
            if(hd.getMahd().toLowerCase().indexOf(ma.toLowerCase()) != -1 ||
                    hd.getManv().toLowerCase().indexOf(ma.toLowerCase()) != -1 ||
                        hd.getMancc().toLowerCase().indexOf(ma.toLowerCase()) != -1)
            dsReturn.add(hd);
        }
        return dsReturn;
    }
    public ArrayList<PhieuNhapDTO> timKiemTheoLuong(int from, int to){
        ArrayList<PhieuNhapDTO> dsReturn = new ArrayList<PhieuNhapDTO>();
        for(PhieuNhapDTO hd:ds){
            if(hd.getTongchi() >= from && hd.getTongchi() <= to)
                dsReturn.add(hd);
        }
        return dsReturn;
    }
    public ArrayList<PhieuNhapDTO> timKiemTheoNgay(String  from, String to){
        ArrayList<PhieuNhapDTO> dsReturn = new ArrayList<PhieuNhapDTO>();
        try{
            for(PhieuNhapDTO hd:ds){
                if(toDate(hd.getNgaynhap()).compareTo(toDate(from)) >= 0 && toDate(hd.getNgaynhap()).compareTo(toDate(to)) <= 0)
                    dsReturn.add(hd);
            }
        }
        catch(Exception e){}
        return dsReturn;
    }
    public Date toDate(String str) throws ParseException{
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(true);
        Date date = df.parse(str);
        return date;
    }
    
    public ArrayList<PhieuNhapDTO> thongKe(String ma,int luongFrom,int luongTo,String ngayFrom,String ngayTo){
        ArrayList<PhieuNhapDTO> list;
        if(ma.equals("")) list=new ArrayList<PhieuNhapDTO>(ds);
        else list = timKiem(ma);
        
        ArrayList<PhieuNhapDTO> list1 = new ArrayList<PhieuNhapDTO>();
        try{
            for(PhieuNhapDTO hd:list){
                if(toDate(hd.getNgaynhap()).compareTo(toDate(ngayFrom)) >= 0 && toDate(hd.getNgaynhap()).compareTo(toDate(ngayTo)) <= 0 && hd.getTongchi() >= luongFrom && hd.getTongchi() <= luongTo)
                    list1.add(hd);
            }
        }
        catch(Exception e){}
        return list1;
    }
     public static void main(String args[]) throws Exception{
        PhieuNhapBUS hd = new PhieuNhapBUS();
        hd.setTongChi("PN001",987654);
    }
}
