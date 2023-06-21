package my_product;

public class FirstProduct {

	String name;
	double price;
	double discontRate;
	double discontePrice;
	public FirstProduct(String name, double price, double discontRate) {
		
		this.name = name;
		this.price = price;
		this.discontRate = discontRate;
		this.discontePrice = price - (price * discontRate / 100);
	}



}
