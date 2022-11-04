package EnterCoupon;
import java.io.Serializable;

public class EnterCouponDetails implements Serializable{
    private String couponCode;
    private String productCode;
    private String producerName;
    private String supplierName;
    private String productName;
    private String enterCouponDate;
    private int price;
    public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getEnterCouponDate() {
		return enterCouponDate;
	}

	public void setEnterCouponDate(String enterCouponDate) {
		this.enterCouponDate = enterCouponDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int amount;
    private int importPrice;
    private int total;
    
    public EnterCouponDetails(){
        couponCode=null;
        productCode=null;
        amount=0;
        importPrice=0;
        price=0;
        producerName=null;
        supplierName=null;;
        productName=null;;
        enterCouponDate=null;
        total=amount*importPrice;
    }
    
	public EnterCouponDetails(String couponCode, String productCode, String producerName, String supplierName, String productName, String enterCouponDate , int price, int amount, int importPrice, int total) {
		this.couponCode = couponCode;
		this.productCode = productCode;
		this.supplierName = supplierName;
		this.productName = productName;
		this.producerName = producerName;
		this.amount = amount;
		this.importPrice = importPrice;
		this.price=price;
		this.enterCouponDate = enterCouponDate;
		this.total = total;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
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

	public int getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(int importPrice) {
		this.importPrice = importPrice;
	}

	public int getTotal() {
		return importPrice*amount;
	}

	public void setTotal(int total) {
		this.total = total;
	}

   
}
