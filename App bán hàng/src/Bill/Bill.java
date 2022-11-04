package Bill;
import java.io.Serializable;

import Users.Customer;
public class Bill implements Serializable{
    public String billCode;
    public String customerCode;
    public String billDate;
    public String employeeCode;
    public int amount;
    public int total;
    public Bill(){
        billCode=null;
        customerCode=null;
        billDate=null;
        employeeCode=null;
        amount=0;
        total=0;
    }

	public Bill(String billCode, String billDate, String employeeCode,int amount, int total) {
		this.billCode = billCode;
		this.billDate = billDate;
		this.employeeCode = employeeCode;
		this.amount=amount;
		this.total = total;
	}

	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
}
