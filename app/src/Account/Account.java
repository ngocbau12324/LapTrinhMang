package Account;
import java.io.*;

import Users.Customer;

public class Account extends Customer implements Serializable{
	private String accountName;
	private String password;
	private String customerCode;
	//private String customerCode;
		// TODO Auto-generated constructor stub

	// contrustor 
	// nhập
	
	public Account() {
		accountName = null;
		password = null;
		customerCode = null;
	}
	
	//set cứng 
	public Account(String accountName, String password, String customerCode) {
		setAccountName(accountName);
		setPassword(password);
		setCustomerCode(customerCode);
	}
	
	public void xuat(){
	    System.out.format("|%8s         |", accountName);
	    System.out.format("%14s         |", password );
	    System.out.format("%10s          |\n", customerCode );
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
}
