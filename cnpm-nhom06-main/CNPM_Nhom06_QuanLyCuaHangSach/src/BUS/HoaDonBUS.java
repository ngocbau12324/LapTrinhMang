/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author vosin
 */
public class HoaDonBUS {
        public static ArrayList<HoaDonDTO> ds;
    public HoaDonBUS(){}
    public void docDuLieu() throws Exception{
        HoaDonDAO data = new HoaDonDAO();
        if(ds == null){
            ds = data.docDuLieu();
        }
    }
    public int them(HoaDonDTO hd) throws Exception{
        HoaDonDAO data = new HoaDonDAO();
        int result = data.them(hd);
        if(result == 1){
            ds.add(hd);
        }
        return result;
    }
    public int sua(HoaDonDTO hd, int i) throws Exception{
        HoaDonDAO data = new HoaDonDAO();
        int result = data.sua(hd);
        if(result == 1){
            ds.set(i,hd);
        }
        return result;
    }
    public int xoa(int i){
        HoaDonDAO data = new HoaDonDAO();
        int result = data.xoa(ds.get(i));
        if(result == 1){
            ds.remove(i);
        }
        return result;
    }
    public Vector load(String str){
        HoaDonDAO data = new HoaDonDAO();
        return data.load(str);
        
    }
    public ArrayList<HoaDonDTO> timKiem(String ma){
        ArrayList<HoaDonDTO> dsReturn = new ArrayList<HoaDonDTO>();
        for(HoaDonDTO hd:ds){
            if(hd.getMahd().toLowerCase().indexOf(ma.toLowerCase()) != -1 ||
                    hd.getManv().toLowerCase().indexOf(ma.toLowerCase()) != -1 ||
                        hd.getMakh().toLowerCase().indexOf(ma.toLowerCase()) != -1)
            dsReturn.add(hd);
        }
        return dsReturn;
    }
    public ArrayList<HoaDonDTO> timKiemTheoLuong(int from, int to){
        ArrayList<HoaDonDTO> dsReturn = new ArrayList<HoaDonDTO>();
        for(HoaDonDTO hd:ds){
            if(hd.getTongchi() >= from && hd.getTongchi() <= to)
                dsReturn.add(hd);
        }
        return dsReturn;
    }
    public ArrayList<HoaDonDTO> timKiemTheoNgay(String  from, String to){
        ArrayList<HoaDonDTO> dsReturn = new ArrayList<HoaDonDTO>();
        try{
            for(HoaDonDTO hd:ds){
                if(toDate(hd.getNgayxuat()).compareTo(toDate(from)) >= 0 && toDate(hd.getNgayxuat()).compareTo(toDate(to)) <= 0)
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
    
    public ArrayList<HoaDonDTO> thongKe(String ma,int luongFrom,int luongTo,String ngayFrom,String ngayTo){
        ArrayList<HoaDonDTO> list;
        if(ma.equals("")) list=new ArrayList<HoaDonDTO>(ds);
        else list = timKiem(ma);
        
        ArrayList<HoaDonDTO> list1 = new ArrayList<HoaDonDTO>();
        try{
            for(HoaDonDTO hd:list){
                if(toDate(hd.getNgayxuat()).compareTo(toDate(ngayFrom)) >= 0 && toDate(hd.getNgayxuat()).compareTo(toDate(ngayTo)) <= 0 && hd.getTongchi() >= luongFrom && hd.getTongchi() <= luongTo)
                    list1.add(hd);
            }
        }
        catch(Exception e){}
        return list1;
    }
    

}
