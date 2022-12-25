package objects;

public class TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ND nd1 = new NDImpl1(); // ND, CTX
		// NDImpl1 là thể hiện của ND
		// số lượng phương thức thực hiện của nd1 phụ thuộc vào ND
		// kết quả phương thức phụ thuộc vào NDImpl1
		BTTU nd2 = new NDImpl2(); // ND, CTX, CTH, GDS, BTTU
		
		BTTU bttu = new BTTUImpl(); // CTX, CTH, GDS, BTTU
		
		
	}

}
