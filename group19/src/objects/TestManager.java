package objects;

public class TestManager {

	public static void main(String[] args) {
		Address addr = new Address();
		
		// Khoi tao doi tuong 
		Person s = new Student("Minh", "Pham Tuan", (byte)19, addr, 2021_00_013, "Cong nghe thong tin");
		Person e = new Employee("Manh", "Le Van",(byte) 23, addr, 2000, "Quan ly");
		
		//-------
		Manager sm = new StudentManager();		
		Manager em = new EmployeeManager();
		System.out.println(sm.getInfor(s));
		System.out.println(em.getInfor(e));
		
	}

}
