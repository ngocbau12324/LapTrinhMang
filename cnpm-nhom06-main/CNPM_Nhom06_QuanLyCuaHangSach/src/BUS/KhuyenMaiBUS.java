/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author tiens
 */
public class KhuyenMaiBUS 
{
    public static ArrayList<KhuyenMaiDTO> ds;	
	public KhuyenMaiBUS() {}	
	public void docKhuyenMai() throws Exception
	{
		KhuyenMaiDAO data = new KhuyenMaiDAO();
		if(ds == null) 
		{
			ds = new ArrayList<KhuyenMaiDTO>();
			ds = data.docKhuyenMai();
		}
	}
	public void DeleteAll()
	{
		KhuyenMaiDAO data = new KhuyenMaiDAO();
        data.DeleteAll();
        ds = new ArrayList<KhuyenMaiDTO>();
    }
	public int them(KhuyenMaiDTO km) 
	{
		KhuyenMaiDAO data = new KhuyenMaiDAO();
        int check = data.them(km);
		if(check == 1) ds.add(km);
		return check;
	}
	public int sua(KhuyenMaiDTO km, int i) 
	{
		KhuyenMaiDAO data = new KhuyenMaiDAO();
		int check = data.sua(km);
        if(check == 1) ds.set(i,km);
        return check;
	}
	public int xoa(int i) 
	{
		KhuyenMaiDTO sp = new KhuyenMaiDTO();
        KhuyenMaiDAO data = new KhuyenMaiDAO();
        sp = ds.get(i);
        int check = data.xoa(sp.getMa());
        if(check == 1) ds.remove(i);
        return check;
	}
    public ArrayList<KhuyenMaiDTO> timKiem(String ma)
    {
    	ArrayList<KhuyenMaiDTO> find = new ArrayList<KhuyenMaiDTO>(); 
        KhuyenMaiDTO sp2;
        for(KhuyenMaiDTO km:ds)
        {
        	if(km.getMa().toLowerCase().indexOf(ma.trim().toLowerCase()) != -1)
        	{
        		sp2 = new KhuyenMaiDTO(km);
                find.add(sp2);
            }                   
        }
        return find;
    }
}
