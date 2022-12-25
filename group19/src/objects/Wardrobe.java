package objects;

public class Wardrobe extends Product {

	// properties
	private int soNgan;
	
	// constructor
	public Wardrobe() {}
	public Wardrobe(String id, String name, double gia, String nsx, int soNgan) {
		super(id, name, gia, nsx);
		this.soNgan = soNgan;
	}
	
	
	// getters and setters
	public int getSoNgan() {
		return soNgan;
	}
	public void setSoNgan(int soNgan) {
		this.soNgan = soNgan;
	}
	
	
	@Override
	public String toString() {
		return "Wardrobe ["+super.toString()+"soNgan=" + soNgan + "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
