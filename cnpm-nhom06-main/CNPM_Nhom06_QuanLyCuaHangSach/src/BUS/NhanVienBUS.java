/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author xenov
 */
public class NhanVienBUS {
    	public static ArrayList<NhanVienDTO> ds;
	
	public NhanVienBUS() {}
	
	public void docNhanVien() throws Exception{
		          NhanVienDAO data = new NhanVienDAO();
		if(ds == null) {
			ds = new ArrayList<NhanVienDTO>();
			ds = data.docNhanVien();
		}
	}
	public void DeleteAll(){
            NhanVienDAO data = new NhanVienDAO();
            data.DeleteAll();
            ds = new ArrayList<NhanVienDTO>();
        }
	public int them(NhanVienDTO nv) {
		NhanVienDAO data = new NhanVienDAO();
                int check = data.them(nv);
		if(check == 1)
                    ds.add(nv);
		return check;
	}
	public int sua(NhanVienDTO nv, int i) {
		NhanVienDAO data = new NhanVienDAO();
		int check = data.sua(nv);
                if(check == 1)
                    ds.set(i,nv);
                return check;
	}
	public int xoa(int i) {
                NhanVienDTO nv = new NhanVienDTO();
                NhanVienDAO data = new NhanVienDAO();
                nv = ds.get(i);
                int check = data.xoa(nv.getMa());
                if(check == 1)
                    ds.remove(i);
                return check;
	}
        public ArrayList<NhanVienDTO> timKiem(String ma){
            ArrayList<NhanVienDTO> find = new ArrayList<NhanVienDTO>(); 
            NhanVienDTO nv2;
            for(NhanVienDTO nv:ds){
                if(nv.getMa().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ||
                   nv.getHo().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ||
                   nv.getTen().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1){
                    nv2 = new NhanVienDTO(nv);
                    find.add(nv2);
                }
                    
            }
            return find;
        }
        public ArrayList<NhanVienDTO> timKiemTheoCaLam(String calam){
            if(calam.equals("Tất cảTất cả")){
                return this.ds;
            }else if (calam.indexOf("Tất cả") != -1){
                String[] calam0 = calam.split("Tất cả");
                if(calam0[0].equals("")) calam = calam0[1];
                else calam = calam0[0];
            }
            ArrayList<NhanVienDTO> find = new ArrayList<NhanVienDTO>();
            NhanVienDTO nv2;
            for(NhanVienDTO nv:ds){
                if(nv.getCa().indexOf(calam)!=-1){
                    nv2 = new NhanVienDTO(nv);
                    find.add(nv2);
                }
                    
            }
            return find;
        }
        public ArrayList<NhanVienDTO> timKiemTheoLuong(int from, int to){
            ArrayList<NhanVienDTO> find = new ArrayList<NhanVienDTO>();
            NhanVienDTO nv2;
            for(NhanVienDTO nv:ds){
                if(nv.getLuong()>= from && nv.getLuong() <= to){
                    nv2 = new NhanVienDTO(nv);
                    find.add(nv2);
                }
                    
            }
            return find;
        }
        
        public ArrayList<NhanVienDTO> thongKe(String ma, String calam, int from, int to){
            ArrayList<NhanVienDTO> find = new ArrayList<NhanVienDTO>();
            find = timKiem(ma);
            NhanVienDTO nv2;
            //ca lam
            if(!calam.equals("Tất cảTất cả")){
                if (calam.indexOf("Tất cả") != -1){
                    String[] calam0 = calam.split("Tất cả");
                    if(calam0[0].equals("")) calam = calam0[1];
                    else calam = calam0[0];
                }
                ArrayList<NhanVienDTO> find1 = new ArrayList<NhanVienDTO>();
                for(NhanVienDTO nv:find){
                    if(nv.getCa().indexOf(calam)!=-1){
                        nv2 = new NhanVienDTO(nv);
                        find1.add(nv2);
                    }  
                }
                find = find1;
            }
            //luong
            ArrayList<NhanVienDTO> find2 = new ArrayList<NhanVienDTO>();
            for(NhanVienDTO nv:find){
                if(nv.getLuong()>= from && nv.getLuong() <= to){
                    nv2 = new NhanVienDTO(nv);
                    find2.add(nv2);
                }  
            }
            return find2;
        }
        
        public ArrayList<NhanVienDTO> TKTheoLuong(int from , int to){
            ArrayList<NhanVienDTO> res = new ArrayList<NhanVienDTO>();
            NhanVienDTO nv2;
           for(NhanVienDTO nv:this.ds){
               if(nv.getLuong() >= from && nv.getLuong() <= to){
                   nv2 = new NhanVienDTO(nv);
                   res.add(nv2);
               }    
           }
           return res;
        }
}
