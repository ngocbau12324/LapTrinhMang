/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
/**
 *
 * @author tiens
 */
public class KhuyenMaiDTO 
{
    private String ma;
	private String mota;
	private String ngaybd;
	private String ngaykt;
	public KhuyenMaiDTO() {}
	public KhuyenMaiDTO(String ma, String mota, String ngaybd, String kt)
	{
		this.ma = ma;
		this.mota = mota;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
	}
	public KhuyenMaiDTO(KhuyenMaiDTO km)
	{
		this.ma = km.ma;
		this.mota = km.mota;
		this.ngaybd = km.ngaybd;
		this.ngaykt = km.ngaykt;
	}
	public String getMa() 
	{
		return ma;
	}
	public void setMa(String ma) 
	{
		this.ma = ma;
	}
	public String getMota() 
	{
		return mota;
	}
	public void setMota(String mota) 
	{
		this.mota = mota;
	}
	public String getNgaybd() 
	{
		return ngaybd;
	}
	public void setNgaybd(String ngaybd) 
	{
		this.ngaybd = ngaybd;
	}
	public String getNgaykt() 
	{
		return ngaykt;
	}
	public void setNgaykt(String ngaykt) 
	{
		this.ngaykt = ngaykt;
	}	
}
