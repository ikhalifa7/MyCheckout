
/**
 * This is a class that acts as a template for making new products.
 * @author Ismaila Khan
 * */


public class Products {

	private String name;
	private String details;
	private double price;



	/**
	 * @param name String
	 * @param details String
	 * @param price double
	 */
	public Products(String name, String details, double price) {
		this.name = name;
		this.details = details;
		this.price = price;
	}



	/**
	 * Returns the name of the product
	 * @return String
	 */
	public String getName() {
		return name;
	}


	/**
	 * 	Returns  the description of the product
	 * @return String
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Returns the price of the product
	 * @return double
	 */
	public double getPrice() {
		return price;
	}


}
