/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhaXuatBanDAO;
import DTO.NhaXuatBanDTO;
import java.util.ArrayList;

/**
 *
 * @author xenov
 */
public class NhaXuatBanBUS {
   public static ArrayList<NhaXuatBanDTO>ds;
   public void docDuLieu() throws Exception{
       NhaXuatBanDAO data = new NhaXuatBanDAO();
       if(ds == null){
           ds = data.docDuLieu();
       }
   }
   
        public void DeleteAll(){
            NhaXuatBanDAO data = new NhaXuatBanDAO();
            data.DeleteAll();
            ds = new ArrayList<NhaXuatBanDTO>();
        }
	public int them(NhaXuatBanDTO nv) {
		NhaXuatBanDAO data = new NhaXuatBanDAO();
                int check = data.them(nv);
		if(check == 1)
                    ds.add(nv);
		return check;
	}
	public int sua(NhaXuatBanDTO nv, int i) {
		NhaXuatBanDAO data = new NhaXuatBanDAO();
		int check = data.sua(nv);
                if(check == 1)
                    ds.set(i,nv);
                return check;
	}
	public int xoa(int i) {
                NhaXuatBanDTO nv = new NhaXuatBanDTO();
                NhaXuatBanDAO data = new NhaXuatBanDAO();
                nv = ds.get(i);
                int check = data.xoa(nv.getMa());
                if(check == 1)
                    ds.remove(i);
                return check;
	}
        public ArrayList<NhaXuatBanDTO> timKiem(String ma){
            ArrayList<NhaXuatBanDTO> find = new ArrayList<NhaXuatBanDTO>(); 
            for(NhaXuatBanDTO ncc:this.ds){
                if(ncc.getMa().toLowerCase().indexOf(ma.toLowerCase()) != -1 ||
                        ncc.getTen().toLowerCase().indexOf(ma.toLowerCase()) != -1 ||
                            ncc.getDiaChi().toLowerCase().indexOf(ma.toLowerCase()) != -1)
                    find.add(new NhaXuatBanDTO(ncc));
            }
            return find;
        }
}
