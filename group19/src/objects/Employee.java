package objects;


public class Employee extends Person {

	// Constants
	public static final int NET=0;
	public static final String POSITION="NONE";
	
	// Employee's properties
	private int net;
	private String position;
	
	// Constructors
	public Employee() {
		
	}
	public Employee(String firstName, String lastName, byte age, Address address, int net, String position) {
		super(firstName, lastName, age, address);
		this.net=net;
		this.position=position;
	}
	
	// getters and setters

	public int getNet() {
		return net;
	}
	public void setNet(int net) {
		this.net = net;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee ["+super.toString()+"net=" + net + ", position=" + position + "]";
	}
	public static void main(String[] args) {
		// khoi tao address
		Address address= new Address();
		// khoi tao employee
		Person employee = new Employee("Manh", "Le Van",(byte) 23, address, 2000, "Quan ly");
		
		System.out.println(employee);

	}

}
