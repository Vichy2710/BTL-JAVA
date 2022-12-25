package objects;

public class Student extends Person {
	
	// Constants
	public static final int ID=0;
	public static final String SPECIALY = "NONE";

	// Student's properties
	private int id;
	private String specialy;
	
	// Constructor methods
	public Student() {
		this(Student.FIRSTNAME, Student.LASTNAME, Student.AGE, Student.ADDRESS, Student.ID, Student.SPECIALY);
	}
	
	public Student(String firstName, String lastName, byte age, Address address, int id, String special) {
		// Khoi tao doi tuong cha (Person)
		super(firstName, lastName, age, address);
		
		// Xac dinh du lieu doi tuong con (Student)
		this.id=id;
		this.specialy=special;
	}
	
	
	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecialy() {
		return specialy;
	}

	public void setSpecialy(String specialy) {
		this.specialy = specialy;
	}
	
	

	@Override
	public String toString() {
		return "Student ["+super.toString()+"id=" + id + ", specialy=" + specialy + "]";
	}

	public static void main(String[] args) {
		// Khoi tao dia chi
		Address addr = new Address();

		// Khoi tao doi tuong sinh vien
		Person s = new Student("Minh", "Pham Tuan", (byte)19, addr, 2021_00_013, "Cong nghe thong tin");
		
		// In thong tin
		System.out.println(s.toString());
	}

}
