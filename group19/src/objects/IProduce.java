package objects;

import java.util.ArrayList;

public interface IProduce {

	public ArrayList<Product> sapXepTheoGia(ArrayList<Product> products, boolean isINC);
	public ArrayList<Product> sapXepTheoTen(ArrayList<Product> products, boolean isINC);
	public ArrayList<Product> timTheoTen(ArrayList<Product> products, String ten);
	public ArrayList<Product> timTheoGia(ArrayList<Product> products, double gia);
}
