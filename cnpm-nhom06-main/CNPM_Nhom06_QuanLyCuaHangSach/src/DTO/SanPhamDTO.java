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
public class SanPhamDTO 
{
    private String ma;
	private String loai;
	private String ten;
	private int dongia;
	private int soluong;
	private String ghichu;
	public SanPhamDTO() {}
	public SanPhamDTO(String ma, String loai, String ten, int dongia, int soluong, String ghichu)
	{
		this.ma = ma;
		this.loai = loai;
		this.ten = ten;
		this.dongia = dongia;
		this.soluong = soluong;
		this.ghichu = ghichu;
	}
	public SanPhamDTO(SanPhamDTO sp)
	{
		this.ma = sp.ma;
		this.loai = sp.loai;
		this.ten = sp.ten;
		this.dongia = sp.dongia;
		this.soluong = sp.soluong;
		this.ghichu = ghichu;
	}
	public String getMa() 
	{
		return ma;
	}
	public void setMa(String ma) 
	{
		this.ma = ma;
	}
	public String getLoai() 
	{
		return loai;
	}
	public void setLoai(String loai) 
	{
		this.loai = loai;
	}
	public String getTen() 
	{
		return ten;
	}
	public void setTen(String ten) 
	{
		this.ten = ten;
	}
	public int getDongia() 
	{
		return dongia;
	}
	public void setDongia(int dongia) 
	{
		this.dongia = dongia;
	}
	public int getSoluong() 
	{
		return soluong;
	}
	public void setSoluong(int soluong) 
	{
		this.soluong = soluong;
	}
	public String getGhichu() 
	{
		return ghichu;
	}
	public void setGhichu(String ghichu) 
	{
		this.ghichu = ghichu;
	}
}
