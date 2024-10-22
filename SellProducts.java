package user_package;

public class SellProducts {
	String productName;
	double price;
	String genre;
	int quantityAvail;
	
	public SellProducts(String productName, double price, String genre, int quantityAvail)
	{
		this.productName = productName;
		this.price = price;
		this.genre = genre;
		this.quantityAvail = quantityAvail;
	}
	
	public SellProducts() {
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getQuantityAvail() {
		return quantityAvail;
	}

	public void setQuantityAvail(int quantityAvail) {
		this.quantityAvail = quantityAvail;
	}
	
	
	
	
	

}