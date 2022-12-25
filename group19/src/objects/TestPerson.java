package objects;

public class TestPerson {

	public static void main(String[] args) {

		// Khoi tao dia chi
		Address addr = new Address();
		
		// Khoi tao doi tuong 
		Person s = new Student("Minh", "Pham Tuan", (byte)19, addr, 2021_00_013, "Cong nghe thong tin");
		Person e = new Employee("Manh", "Le Van",(byte) 23, addr, 2000, "Quan ly");
		// => đa hình
				
		// In thong tin
		System.out.println(s.toString());
		System.out.println(e.toString());

	}

}
