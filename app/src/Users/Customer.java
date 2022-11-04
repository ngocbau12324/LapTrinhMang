package Users;

import Dungchung.person;
import java.io.Serializable;

import Account.Account;
import Account.ArrayAccount;

public class Customer extends person implements Serializable{
    String customerCode;
    public Customer () {
        super();
        customerCode=null;
    }
    
	public Customer(String name, String numberPhone, String address, String customerCode) {
		super(name, numberPhone, address);
		// TODO Auto-generated constructor stub
		setCustomerCode(customerCode);
	}

	public void display(){
        System.out.format("|%8s         | ", customerCode);
        System.out.format("%12s          | ", super.getName());
        System.out.format("%12s  | ", super.getAddress());
        System.out.format("%12s      |\n", super.getNumberPhone());
    }

	public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
     public String getName() {
        return super.getName();
    } 
     
    public String getAddress() {
        return super.getAddress();
    }
    
    public String getNumberPhone() {
        return super.getNumberPhone();
    }
     public void setName(String name) {
        super.setName(name);
    }
    public void setAddress(String address) {
        super.setAddress(address);
    }
    public void setNumberPhone(String numberPhone) {
        super.setNumberPhone(numberPhone);
    }
}
