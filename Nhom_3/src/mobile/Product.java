package mobile;
import java.util.Scanner;

public class Product {

	static Scanner scanner = new Scanner(System.in);
	// properties
	protected String product_id;
	protected String product_name;
	protected double product_price;
	protected int product_total;
	
	// constructors
	public Product() {
		this(null, null, 0.0, 0);
	}
	public Product(String product_id, String product_name, double product_price, int product_total) {
		
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_total = product_total;
	}
	
	// getters and setters
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getProduct_total() {
		return product_total;
	}
	public void setProduct_total(int product_total) {
		this.product_total = product_total;
	}
	
	// toString() method
	@Override
	public String toString() {
		return "product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_total=" + product_total + " ";
	}
	
	// other methods
	/**
	 * This method is used to enter a new product
	 */
	public void Input() {
		System.out.print("Input product's id: ");
		product_id = scanner.nextLine();
		System.out.print("Input product's name: ");
		product_name = scanner.nextLine();
		System.out.print("Input product's price: ");
		product_price = scanner.nextDouble();
		System.out.print("Input product's total: ");
		product_total = scanner.nextInt();
	}
	
}
