/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author xenov
 */
public class ChiTietPhieuNhapBUS {
    public static ArrayList<ChiTietPhieuNhapDTO> ds;
	public ChiTietPhieuNhapBUS() {}
	public void docDuLieu() throws Exception{
		          ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
		if(ds == null) {
			ds = new ArrayList<ChiTietPhieuNhapDTO>();
			ds = data.docDuLieu();
		}
	}
	public void DeleteAll(){
            ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
            data.DeleteAll();
            ds = new ArrayList<ChiTietPhieuNhapDTO>();
        }
        public int getTong(String ma){
            int tong=0;
            for(ChiTietPhieuNhapDTO hd: this.ds){
                if(hd.getMahd().equals(ma)) tong+=hd.getThanhtien();
            }
            return tong;
        }
        public int setTong (String ma) throws Exception{
            PhieuNhapBUS bus = new PhieuNhapBUS();
            int value=getTong(ma);
            int res = bus.setTongChi(ma, value);
            return res;
        }
	public int them(ChiTietPhieuNhapDTO nv) {
		ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
                int check = data.them(nv);
		if(check == 1)
                    ds.add(nv);
                try{
                    if(setTong(nv.getMahd()) != 1) return 0;
                }catch(Exception e){}
		return check;
	}
	public int sua(ChiTietPhieuNhapDTO nv, int i) {
		ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
		int check = data.sua(nv);
                if(check == 1)
                    ds.set(i,nv);
                try{
                    if(setTong(nv.getMahd()) != 1) return 0;
                }catch(Exception e){}
                return check;
	}
	public int xoa(int i) {
                ChiTietPhieuNhapDTO nv = new ChiTietPhieuNhapDTO();
                ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
                nv = ds.get(i);
                int check = data.xoa(nv.getMahd(),nv.getMasp());
                if(check == 1)
                    ds.remove(i);
                try{
                    if(setTong(nv.getMahd()) != 1) return 0;
                }catch(Exception e){}
                return check;
	}
        public ArrayList<ChiTietPhieuNhapDTO> timKiem(String ma){
            ArrayList<ChiTietPhieuNhapDTO> find = new ArrayList<ChiTietPhieuNhapDTO>(); 
            ChiTietPhieuNhapDTO nv2;
            for(ChiTietPhieuNhapDTO nv:ds){
                if(nv.getMahd().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ||
                   nv.getMasp().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ){
                    nv2 = new ChiTietPhieuNhapDTO(nv);
                    find.add(nv2);
                } 
            }
            return find;
        }
        public Vector load(String str){
            ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
            return data.load(str);

        }
        public String get(String table,String ma) throws Exception{
            ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
            return data.get(table,ma);
        }
        public ArrayList<ChiTietPhieuNhapDTO> timKiemTheoDonGia(int from, int to){
            ArrayList<ChiTietPhieuNhapDTO> find = new ArrayList<ChiTietPhieuNhapDTO>();
            ChiTietPhieuNhapDTO nv2;
            for(ChiTietPhieuNhapDTO nv:ds){
                if(nv.getDongia()>= from && nv.getDongia() <= to){
                    nv2 = new ChiTietPhieuNhapDTO(nv);
                    find.add(nv2);
                }   
            }
            return find;
        }
        public ArrayList<ChiTietPhieuNhapDTO> timKiemTheoSoLuong(int from, int to){
            ArrayList<ChiTietPhieuNhapDTO> find = new ArrayList<ChiTietPhieuNhapDTO>();
            ChiTietPhieuNhapDTO nv2;
            for(ChiTietPhieuNhapDTO nv:ds){
                if(nv.getSoluong()>= from && nv.getSoluong() <= to){
                    nv2 = new ChiTietPhieuNhapDTO(nv);
                    find.add(nv2);
                }  
            }
            return find;
        }
        public ArrayList<ChiTietPhieuNhapDTO> timKiemTheoThanhTien(int from, int to){
            ArrayList<ChiTietPhieuNhapDTO> find = new ArrayList<ChiTietPhieuNhapDTO>();
            ChiTietPhieuNhapDTO nv2;
            for(ChiTietPhieuNhapDTO nv:ds){
                if(nv.getThanhtien() >= from && nv.getThanhtien() <= to){
                    nv2 = new ChiTietPhieuNhapDTO(nv);
                    find.add(nv2);
                } 
            }
            return find;
        }
        public ArrayList<ChiTietPhieuNhapDTO> thongKe(String mahd,String masp,int fromDonGia,int toDonGia,int fromSoLuong, int toSoLuong, int fromThanhTien, int toThanhTien){
           
            ArrayList<ChiTietPhieuNhapDTO> find = new ArrayList<ChiTietPhieuNhapDTO>();
            if(mahd.equals("Tất cả")) find=this.ds;
            else find=timKiem(mahd);
          
            ArrayList<ChiTietPhieuNhapDTO> find2 = new ArrayList<ChiTietPhieuNhapDTO>(); 
            if(!masp.equals("Tất cả")){
                    ChiTietPhieuNhapDTO nv2;
                    for(ChiTietPhieuNhapDTO nv:find){
                        if(nv.getMasp().toLowerCase().indexOf(masp.trim().toLowerCase()) != -1 ){
                            nv2 = new ChiTietPhieuNhapDTO(nv);
                            find2.add(nv2);
                        } 
                    }
            }else find2=find;
          
            ArrayList<ChiTietPhieuNhapDTO> find3 = new ArrayList<ChiTietPhieuNhapDTO>();
            ChiTietPhieuNhapDTO nv2;
            for(ChiTietPhieuNhapDTO nv:find2){
                if(nv.getDongia()>= fromDonGia && nv.getDongia() <= toDonGia){
                    nv2 = new ChiTietPhieuNhapDTO(nv);
                    find3.add(nv2);
                }   
            }
           
            ArrayList<ChiTietPhieuNhapDTO> find4 = new ArrayList<ChiTietPhieuNhapDTO>();
            for(ChiTietPhieuNhapDTO nv:find3){
                if(nv.getSoluong()>= fromSoLuong && nv.getSoluong() <= toSoLuong){
                    nv2 = new ChiTietPhieuNhapDTO(nv);
                    find4.add(nv2);
                }  
            }
        
            ArrayList<ChiTietPhieuNhapDTO> find5 = new ArrayList<ChiTietPhieuNhapDTO>();
            for(ChiTietPhieuNhapDTO nv:find4){
                if(nv.getThanhtien() >= fromThanhTien && nv.getThanhtien() <= toThanhTien){
                    nv2 = new ChiTietPhieuNhapDTO(nv);
                    find5.add(nv2);
                } 
            }
       
            return find5;
        }
}
