package userService;

import Product.Product;

public class Cart extends Product{

	String orderCode;
	public Cart() {
		super();
		orderCode = null;
		// TODO Auto-generated constructor stub
	}

	public Cart(String productCode, String productName, String manufacturer, String producerName, String supplierName,
			int amount, int importPrice, int price) {
		super(productCode, productName, producerName, supplierName, amount, importPrice, price);
		// TODO Auto-generated constructor stub
		setOrderCode(orderCode);
	}
	
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
}
