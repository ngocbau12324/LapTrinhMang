package EnterCoupon;

import java.io.Serializable;

public class EnterCoupon implements Serializable{
    private String couponCode;
    private String date;
    private String employeeCode;
    private int total;
    
    public EnterCoupon(){
        couponCode=null;
        date=null;
        employeeCode=null;
        total=0;
    }
    
	public EnterCoupon(String couponCode, String date, String employeeCode, int total) {
		this.couponCode = couponCode;
		this.date = date;
		this.employeeCode = employeeCode;
		this.total = total;
	}

	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
   
    
}
