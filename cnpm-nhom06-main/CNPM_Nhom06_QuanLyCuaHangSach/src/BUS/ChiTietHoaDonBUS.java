/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author vosin
 */
public class ChiTietHoaDonBUS {
    public static ArrayList<ChiTietHoaDonDTO> ds;
    public ChiTietHoaDonBUS() {}
	public void docDuLieu() throws Exception{
		          ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
		if(ds == null) {
			ds = new ArrayList<ChiTietHoaDonDTO>();
			ds = data.docDuLieu();
		}
	}
        
        public void DeleteAll(){
            ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
            data.DeleteAll();
            ds = new ArrayList<ChiTietHoaDonDTO>();
        }
        
        public int them(ChiTietHoaDonDTO ct) {
		ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
                int check = data.them(ct);
		if(check == 1)
                    ds.add(ct);
		return check;
	}
        
        
        
        public int sua(ChiTietHoaDonDTO ct, int i) {
		ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
		int check = data.sua(ct);
                if(check == 1)
                    ds.set(i,ct);
                return check;
	}
        
        public int xoa(int i) {
                ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO();
                ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
                ct = ds.get(i);
                int check = data.xoa(ct.getMahd(),ct.getMasp());
                if(check == 1)
                    ds.remove(i);
                return check;
	}
        
        public ArrayList<ChiTietHoaDonDTO> timKiem(String ma){
            ArrayList<ChiTietHoaDonDTO> find = new ArrayList<ChiTietHoaDonDTO>(); 
            ChiTietHoaDonDTO ct2;
            for(ChiTietHoaDonDTO ct:ds){
                if(ct.getMahd().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ||
                   ct.getMasp().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ){
                    ct2 = new ChiTietHoaDonDTO(ct);
                    find.add(ct2);
                } 
            }
            return find;
        }
        
        public Vector load(String str){
            ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
            return data.load(str);
        }
        
         public String get(String table,String ma) throws Exception{
            ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
            return data.get(table,ma);
        }
          public String getDonGia(String table,String ma) throws Exception{
            ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
            return data.getDonGia(table,ma);
        }
          public String getgiamgia(String table,String ma, String makm) throws Exception{
            ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
            return data.getgiamgia(table,ma,makm);
        }
         
         
         public ArrayList<ChiTietHoaDonDTO> timKiemTheoDonGia(int from, int to){
            ArrayList<ChiTietHoaDonDTO> find = new ArrayList<ChiTietHoaDonDTO>();
            ChiTietHoaDonDTO ct2;
            for(ChiTietHoaDonDTO ct:ds){
                if(ct.getDongia()>= from && ct.getDongia() <= to){
                    ct2 = new ChiTietHoaDonDTO(ct);
                    find.add(ct2);
                }   
            }
            return find;
        }
         
         public ArrayList<ChiTietHoaDonDTO> timKiemTheoSoLuong(int from, int to){
            ArrayList<ChiTietHoaDonDTO> find = new ArrayList<ChiTietHoaDonDTO>();
            ChiTietHoaDonDTO ct2;
            for(ChiTietHoaDonDTO ct:ds){
                if(ct.getSoluong()>= from && ct.getSoluong() <= to){
                    ct2 = new ChiTietHoaDonDTO(ct);
                    find.add(ct2);
                }  
            }
            return find;
        }
        
         public ArrayList<ChiTietHoaDonDTO> timKiemTheoThanhTien(int from, int to){
            ArrayList<ChiTietHoaDonDTO> find = new ArrayList<ChiTietHoaDonDTO>();
            ChiTietHoaDonDTO ct2;
            for(ChiTietHoaDonDTO ct:ds){
                if(ct.getThanhtien() >= from && ct.getThanhtien() <= to){
                    ct2 = new ChiTietHoaDonDTO(ct);
                    find.add(ct2);
                } 
            }
            return find;
        }
         
         public ArrayList<ChiTietHoaDonDTO> thongKe(String mahd,String masp,int fromDonGia,int toDonGia,int fromSoLuong, int toSoLuong, int fromThanhTien, int toThanhTien){
           
            ArrayList<ChiTietHoaDonDTO> find = new ArrayList<ChiTietHoaDonDTO>();
            if(mahd.equals("Tất cả")) find=this.ds;
            else find=timKiem(mahd);
          
            ArrayList<ChiTietHoaDonDTO> find2 = new ArrayList<ChiTietHoaDonDTO>(); 
            if(!masp.equals("Tất cả")){
                    ChiTietHoaDonDTO ct2;
                    for(ChiTietHoaDonDTO ct:find){
                        if(ct.getMasp().toLowerCase().indexOf(masp.trim().toLowerCase()) != -1 ){
                            ct2 = new ChiTietHoaDonDTO(ct);
                            find2.add(ct2);
                        } 
                    }
            }else find2=find;
          
            ArrayList<ChiTietHoaDonDTO> find3 = new ArrayList<ChiTietHoaDonDTO>();
            ChiTietHoaDonDTO ct2;
            for(ChiTietHoaDonDTO ct:find2){
                if(ct.getDongia()>= fromDonGia && ct.getDongia() <= toDonGia){
                    ct2 = new ChiTietHoaDonDTO(ct);
                    find3.add(ct2);
                }   
            }
           
            ArrayList<ChiTietHoaDonDTO> find4 = new ArrayList<ChiTietHoaDonDTO>();
            for(ChiTietHoaDonDTO ct:find3){
                if(ct.getSoluong()>= fromSoLuong && ct.getSoluong() <= toSoLuong){
                    ct2 = new ChiTietHoaDonDTO(ct);
                    find4.add(ct2);
                }  
            }
        
            ArrayList<ChiTietHoaDonDTO> find5 = new ArrayList<ChiTietHoaDonDTO>();
            for(ChiTietHoaDonDTO ct:find4){
                if(ct.getThanhtien() >= fromThanhTien && ct.getThanhtien() <= toThanhTien){
                    ct2 = new ChiTietHoaDonDTO(ct);
                    find5.add(ct2);
                } 
            }
       
            return find5;
        }
        
}
