/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author tiens
 */
public class SanPhamBUS 
{
    public static ArrayList<SanPhamDTO> ds;	
	public SanPhamBUS() {}	
	public void docSanPham() throws Exception
	{
		SanPhamDAO data = new SanPhamDAO();
		if(ds == null) 
		{
			ds = new ArrayList<SanPhamDTO>();
			ds = data.docSanPham();
		}
	}
	public void DeleteAll()
	{
		SanPhamDAO data = new SanPhamDAO();
        data.DeleteAll();
        ds = new ArrayList<SanPhamDTO>();
    }
	public int them(SanPhamDTO sp) 
	{
            SanPhamDAO data = new SanPhamDAO();
            int check = data.them(sp);
            if(check == 1) ds.add(sp);
            return check;
	}
	public int sua(SanPhamDTO sp, int i) 
	{
		SanPhamDAO data = new SanPhamDAO();
		int check = data.sua(sp);
        if(check == 1) ds.set(i,sp);
        return check;
	}
	public int xoa(int i) 
	{
		SanPhamDTO sp = new SanPhamDTO();
        SanPhamDAO data = new SanPhamDAO();
        sp = ds.get(i);
        int check = data.xoa(sp.getMa());
        if(check == 1) ds.remove(i);
        return check;
	}
    public ArrayList<SanPhamDTO> timKiem(String ma)
    {
    	ArrayList<SanPhamDTO> find = new ArrayList<SanPhamDTO>(); 
        SanPhamDTO sp2;
        for(SanPhamDTO sp:ds)
        {
        	if(sp.getMa().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ||
               sp.getLoai().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 ||
               sp.getTen().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1)
        	{
        		sp2 = new SanPhamDTO(sp);
                find.add(sp2);
            }                   
        }
        return find;
    }
    public ArrayList<SanPhamDTO> thongKe(String ma, String Tusl, String Densl, String Tudg, String Dendg)
    {
        ArrayList<SanPhamDTO> find = new ArrayList<SanPhamDTO>(); 
        SanPhamDTO sp2;
         ArrayList<SanPhamDTO> sl = new ArrayList<SanPhamDTO>();
        for(SanPhamDTO sp:find)
        {
        	if(sp.getMa().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1 &&
                Integer.parseInt(Tusl) <= sp.getSoluong()&&
                sp.getSoluong() <= Integer.parseInt(Densl) &&
                Integer.parseInt(Tusl) <= sp.getDongia() &&
                sp.getDongia() <= Integer.parseInt(Dendg))              
            {
        	sp2 = new SanPhamDTO(sp);
                sl.add(sp2);
            }                   
        }
        return sl;
    }
    public int ThemBotSoLuongSanPham(String ma, int value){
        SanPhamDAO data = new SanPhamDAO();
        return data.ThemBotSoLuongSanPham(ma,value);
    }
}
