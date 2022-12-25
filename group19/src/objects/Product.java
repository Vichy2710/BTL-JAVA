package objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Product implements IProduce {

	// constants
	
	// properties
	protected String id;
	protected String ten;
	protected double gia;
	protected String nsx;
	
	// constructor
	public Product(String id,String name, double gia, String nsx) {
		super();
		this.id = id;
		this.ten=name;
		this.gia = gia;
		this.nsx = nsx;
	}
	public Product() {}
	
	// getters and setters
	
	public String getId() {
		return id;
	}
	public String getName() {
		return ten;
	}
	public void setName(String name) {
		this.ten = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getNsx() {
		return nsx;
	}
	public void setNsx(String nsx) {
		this.nsx = nsx;
	}
	
	// methods
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + ten + ", gia=" + gia + ", nsx=" + nsx + "]";
	}
	

	public static void main(String[] args) {

		Product a = new Chair("p1", "ghe sofa",2300.0,"IKEA",5.3);
		Product b = new Table("p2", "ban tra",2100.0,"IKEA","Ban kinh");
		Product c = new Wardrobe("p3", "tu mini",8900.0,"IKEA",5);

		ArrayList<Product> products = new ArrayList<>();
		products.add(a);
		products.add(b);
		products.add(c);
		
		new Product().sapXepTheoGia(products, true);
		for (Product product : products) {
			System.out.println(product);
		}
		
		//System.out.println(new Product().timTheoGia(products, 2300.0));
	}
	
	// inner class
	class sortByPrice implements Comparator<Product>{

		@Override
		public int compare(Product o1, Product o2) {
			// TODO Auto-generated method stub
			return Double.compare(o1.getGia(), o2.getGia());
		}
		
	}
	class sortByName implements Comparator<Product>{

		@Override
		public int compare(Product o1, Product o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	@Override
	public ArrayList<Product> sapXepTheoGia(ArrayList<Product> products, boolean isINC) {
		if(isINC)
			Collections.sort(products, new sortByPrice());
		else {
			Collections.sort(products, new sortByPrice().reversed());
		}
		return products;
	}
	@Override
	public ArrayList<Product> sapXepTheoTen(ArrayList<Product> products, boolean isINC) {
		if(isINC)
			Collections.sort(products, new sortByName());
		else {
			Collections.sort(products, new sortByName().reversed());
		}
		return products;
	}
	@Override
	public ArrayList<Product> timTheoGia(ArrayList<Product> products, double gia) {
		ArrayList<Product> result = new ArrayList<>();
		for (Product product : products) {
			if(product.getGia()==gia)
				result.add(product);
		}
		return result;
	}
	@Override
	public ArrayList<Product> timTheoTen(ArrayList<Product> products, String name) {
		ArrayList<Product> result = new ArrayList<>();
		for (Product product : products) {
			if(product.getName().equalsIgnoreCase(name))
				result.add(product);
		}
		return result;
	}


}
