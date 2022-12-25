package objects;

public class Table extends Product {

	// properties
	private String loai;
	
	// constructor
	public Table() {}
	public Table(String id,String ten, double gia, String nsx, String loai) {
		super(id, ten, gia, nsx);
		this.loai = loai;
	}

	
	
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	@Override
	public String toString() {
		return "Table ["+super.toString()+" , loai=" + loai + "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
