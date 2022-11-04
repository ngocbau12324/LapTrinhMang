package Supplier;

import java.io.Serializable;
import Dungchung.person;

public class Supplier extends person implements Serializable {
	private String supplierCode;
	
    public Supplier() {
            super();
            supplierCode=null;
    }
    
    public Supplier(String name, String numberPhone, String address, String supplierCode) {
		super(name, numberPhone, address);
		// TODO Auto-generated constructor stub
		setSupplierCode(supplierCode);
	}

	public void xuat(){
        System.out.format("%13s | ", supplierCode);
        System.out.format("%22s | ", super.getName());
        System.out.format("%17s | ", super.getAddress());
        System.out.format("%22s |\n", super.getNumberPhone());
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
    
     public String getSupplierName() {
        return super.getName();
    } 
     
    public String getAddress() {
        return super.getAddress();
    }
    
    public String getNumberPhone() {
        return super.getNumberPhone();
    }
     public void setSupplierName(String supplierName) {
        super.setName(supplierName);
    }
    public void setAddress(String address) {
        super.setAddress(address);
    }
    public void setNumberPhone(String numberPhone) {
        super.setNumberPhone(numberPhone);
    }

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
