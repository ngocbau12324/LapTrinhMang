package Product;

public class Iphone extends Product{
	public Iphone() {
		super();
	}
	public String producerName() {
		super.setProducerName("Iphone");
		return super.getProducerName();
	}
}
