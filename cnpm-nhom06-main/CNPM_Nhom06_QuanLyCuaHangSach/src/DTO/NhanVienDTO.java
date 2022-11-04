/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


/**
 *
 * @author xenov
 */
public class NhanVienDTO {
    private String ma;
	private String ho;
	private String ten;
	private String ca;
	private String ngaysinh;
	private boolean gioitinh;
	private int luong;
	
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getCa() {
		return ca;
	}
	public void setCa(String ca) {
		this.ca = ca;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
      
	public NhanVienDTO() {
		this("3117410140","Nguuyen Van","Long","Chieu thu 2","17/03/1999",true,10000000);
	}
	public NhanVienDTO(String ma, String ho, String ten, String ca, String ngaysinh, boolean gioitinh, int luong) {
		this.ma = ma;
		this.ho = ho;
		this.ten = ten;
		this.ca = ca;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.luong = luong;
	}
        public NhanVienDTO(NhanVienDTO nv){
            this(nv.getMa(),nv.getHo(),nv.getTen(),nv.getCa(),nv.getNgaysinh(),nv.isGioitinh(),nv.getLuong());
        }
	
}
