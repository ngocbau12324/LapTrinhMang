/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ThongTinKhuyenMaiDAO;
import DTO.ThongTinKhuyenMaiDTO;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author tiens
 */
public class ThongTinKhuyenMaiBUS {
    public static ArrayList<ThongTinKhuyenMaiDTO> ds;
	
	public ThongTinKhuyenMaiBUS() {}
	
	public void docNhanVien() throws Exception{
		ThongTinKhuyenMaiDAO data = new ThongTinKhuyenMaiDAO();
		if(ds == null) {
			ds = new ArrayList<ThongTinKhuyenMaiDTO>();
			ds = data.docNhanVien();
		}
	}
	public void DeleteAll(){
            ThongTinKhuyenMaiDAO data = new ThongTinKhuyenMaiDAO();
            data.DeleteAll();
            ds = new ArrayList<ThongTinKhuyenMaiDTO>();
        }
	public int them(ThongTinKhuyenMaiDTO nv) {
		ThongTinKhuyenMaiDAO data = new ThongTinKhuyenMaiDAO();
                int check = data.them(nv);
		if(check == 1)
                    ds.add(nv);
		return check;
	}
	public int sua(ThongTinKhuyenMaiDTO nv, int i) {
		ThongTinKhuyenMaiDAO data = new ThongTinKhuyenMaiDAO();
		int check = data.sua(nv);
                if(check == 1)
                    ds.set(i,nv);
                return check;
	}
	public int xoa(int i) {
                ThongTinKhuyenMaiDTO nv = new ThongTinKhuyenMaiDTO();
                ThongTinKhuyenMaiDAO data = new ThongTinKhuyenMaiDAO();
                nv = ds.get(i);
                int check = data.xoa(nv.getMakm(),nv.getMasp());
                if(check == 1)
                    ds.remove(i);
                return check;
	}
        public ArrayList<ThongTinKhuyenMaiDTO> timKiem(String ma) throws Exception{
            ArrayList<ThongTinKhuyenMaiDTO> find = new ArrayList<ThongTinKhuyenMaiDTO>(); 
            ThongTinKhuyenMaiDTO nv2;
            for(ThongTinKhuyenMaiDTO nv:ds){
                if(nv.getMakm().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ||
                   nv.getMasp().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ||
                   nv.getQua().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1){
                    nv2 = new ThongTinKhuyenMaiDTO(nv);
                    find.add(nv2);
                }  
            }
            return find;
        }
        
        public ArrayList<ThongTinKhuyenMaiDTO> timKiemTheoGiamGia(int from, int to){
            ArrayList<ThongTinKhuyenMaiDTO> find = new ArrayList<ThongTinKhuyenMaiDTO>();
            ThongTinKhuyenMaiDTO nv2;
            for(ThongTinKhuyenMaiDTO nv:ds){
                if(Integer.parseInt(nv.getGiamgia())>= from && Integer.parseInt(nv.getGiamgia()) <= to){
                    nv2 = new ThongTinKhuyenMaiDTO(nv);
                    find.add(nv2);
                }    
            }
            return find;
        }
        public ArrayList<ThongTinKhuyenMaiDTO> thongKe(String makm,String masp,int giaFrom, int giaTo,String qua) throws Exception{
            ArrayList<ThongTinKhuyenMaiDTO> find = new ArrayList<ThongTinKhuyenMaiDTO>(); 
            ThongTinKhuyenMaiDTO nv2;
            if(makm.equals("Tất cả") && masp.equals("Tất cả")) find=this.ds;
            else if(makm.equals("Tất cả")) find=timKiem(masp);
                else if (masp.equals("Tất cả")) find=timKiem(makm);
                else{
                        for(ThongTinKhuyenMaiDTO nv:ds){
                            if(nv.getMakm().toLowerCase().equals(makm.toLowerCase()) &&
                               nv.getMasp().toLowerCase().equals(masp.toLowerCase())){
                                nv2 = new ThongTinKhuyenMaiDTO(nv);
                                find.add(nv2);
                            }  
                        }
                }
            
            ArrayList<ThongTinKhuyenMaiDTO> find1 = new ArrayList<ThongTinKhuyenMaiDTO>(); 
            for(ThongTinKhuyenMaiDTO nv:find){
                if(Integer.parseInt(nv.getGiamgia())>= giaFrom && Integer.parseInt(nv.getGiamgia()) <= giaTo){
                    nv2 = new ThongTinKhuyenMaiDTO(nv);
                    find1.add(nv2);
                }    
            }
            
            ArrayList<ThongTinKhuyenMaiDTO> find2 = new ArrayList<ThongTinKhuyenMaiDTO>();
            if(qua.equals("Tất cả")) return find1;
            if(qua.equals("Có")){
                for(ThongTinKhuyenMaiDTO nv:find1){
                    if(nv.getQua().length() > 0){
                        nv2 = new ThongTinKhuyenMaiDTO(nv);
                        find2.add(nv2);
                    }    
                }
            }else if(qua.equals("Không")){
                for(ThongTinKhuyenMaiDTO nv:find1){
                    if(nv.getQua().length() == 0){
                        nv2 = new ThongTinKhuyenMaiDTO(nv);
                        find2.add(nv2);
                    }    
                }
            }
            
            return find2;
        }
        
        public Vector load(String str) throws Exception{
            ThongTinKhuyenMaiDAO data = new ThongTinKhuyenMaiDAO();
            Vector res = data.load(str);
            return res;
            
        }
        
}
