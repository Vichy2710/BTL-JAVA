package objects;

public class Chair extends Product {

	// properties
	private double chieuCao;
	
	// constructor
	public Chair(String id, String ten, double gia, String nsx, double chieuCao) {
		super(id, ten, gia, nsx);
		this.chieuCao = chieuCao;
	}
	public Chair() {}
	
	
	@Override
	public String toString() {
		return "Chair ["+super.toString()+" , chieuCao=" + chieuCao + "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
