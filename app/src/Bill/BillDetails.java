package Bill;
import java.io.Serializable;

import Users.Customer;
public class BillDetails extends Customer implements Serializable{
    public String billDetailsCode;
    public String productCode;
    public String productName;
    public int amount;
    public int price;
    public String billDate;
    public String employeeCode;
    public float total;
    public BillDetails(){
        billDetailsCode=null;
        productCode=null;
        amount=0;
        price=0;
        total=amount * price;
    }
    
	public BillDetails(String name, String numberPhone, String address, String billDetailsCode, String customerCode, String billDate, String employeeCode, String productCode, String productName, int amount, int price, int total) {
		super(name, numberPhone, address, customerCode);//
		// TODO Auto-generated constructor stub
		this.billDetailsCode = billDetailsCode;
		this.billDate = billDate;
		this.employeeCode = employeeCode;
		this.amount = amount;
		this.price = price;
		this.productCode = productCode;
		this.productName = productName;
		this.total = total;
	}
	
	public BillDetails(String billDetailsCode, String productCode, int amount, int price, float total) {
		this.billDetailsCode = billDetailsCode;
		this.productCode = productCode;
		this.amount = amount;
		this.price = price;
		this.total = amount * price;
	}

	public String getBillCode() {
		return billDetailsCode;
	}
	public void setBillCode(String billCode) {
		this.billDetailsCode = billCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getTotal() {
		return amount * price;
	}
	public void setTotal(float total) {
		this.total = total;
	}

	public String getBillDetailsCode() {
		return billDetailsCode;
	}

	public void setBillDetailsCode(String billDetailsCode) {
		this.billDetailsCode = billDetailsCode;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
