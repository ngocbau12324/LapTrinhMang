package Product;

public class Samsung extends Product {
	public Samsung() {
		super();
	}
	public String producerName() {
		super.setProducerName("Samsung");
		return super.getProducerName();
	}
}
