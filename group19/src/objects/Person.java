package objects;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable{
	
	// Constants
	public static final String FIRSTNAME = "No FirstName";
	public static final String LASTNAME = "No LastName";
	public static final byte AGE = 0;
	public static final Address ADDRESS = new Address();
	
	// Classes' variables
	private static int count=0;
	
	// Object's properties
	private String firstName;
	private String lastName;
	private byte age;
	
	private Address address;
	
	// Constructor methods
	public Person() {
		/*
		 * firstName = "No FirstName"; lastName = "No LastName"; age = 0;
		 */
		
		this(Person.FIRSTNAME, Person.LASTNAME, Person.AGE, Person.ADDRESS);
	}
	// constructor cũng có thể overload
	public Person(byte age) {
		this(Person.FIRSTNAME, Person.LASTNAME, age, Person.ADDRESS);
		
	}
	public Person(String firstName, String lastName, byte age, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		
		// Cach 1: gán địa chỉ trong bộ nhớ -> cùng địa chỉ vùng nhớ
		this.address = address;
		
		// Cach 2: khởi tạo bộ nhớ mới và sao chép giá trị
		//this.address = new Address(address);
		
		
		// Increase value of count than 1
		Person.count++;
	}
	
	// Getter methods
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public byte getAge() {
		return this.age;
	}
	public Address getAddress() {
		return this.address;
	}
	
	// Setter methods
	public void setFirstName(String f) {
		this.firstName = f;
	}
	public void setLastName(String l) {
		this.lastName = l;
	}
	public void setAge(byte a) {
		this.age = a;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setAdress(String cityName, String districtName, String streetName) {
		this.address =  new Address(cityName, districtName, streetName);
	}
	
	// Other methods
	public String toString() {
		return String.format(" %-10s%-17s%-4d", lastName,firstName,age);
	}
	
	public static int getCountPerson() {
		return Person.count;
	}
	
	public static void main(String[] args) {
		// Khai báo và khởi tạo đối tượng
		
		Address addr = new Address("Ha Noi", "Bac Tu Liem", "Pho Nhon");
		
		Person p;
		Person p1 = new Person();
		Person p2 = new Person((byte)20);
		Person p3 = new Person("Vi", "Ngo", (byte)19, addr);
		
		addr.setStreetName("Kieu Mai");
		
//		System.out.println(p1);
//		System.out.println(p2);
		System.out.println(p3);
		
		System.out.println("So doi tuong duoc tao ra la: "+ Person.getCountPerson());
		
		/*
		 * String a ="abc"; String b= new String("abc"); System.out.println(a==b); => false
		 */
		
	}
	@Override
	public int compareTo(Person o) {
		return this.age - o.getAge();
	}

}
