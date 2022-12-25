package car.test01;

import java.io.Serializable;
import java.util.Objects;

public class Car  extends Product implements Serializable{
	public static final double CYLINDER_CAPACITY = 0;
	public static final int SEAT = 0;
	
	private double cylinderCapacity;
	private int seat;
	
	public Car() {
		this(Car.ID, Car.NAME, Car.PRICE, Car.TOTAL, Car.CYLINDER_CAPACITY, Car.SEAT);
	}
	
	
	public Car(int product_id, String product_name, double product_price, int product_total, double cylinderCapacity, int seat) {
		super(product_id, product_name, product_price, product_total);
		this.cylinderCapacity = cylinderCapacity;
		this.seat = seat;
	}
	
	public double getCylinderCapacity() {
		return cylinderCapacity;
	}

	public int getSeat() {
		return seat;
	}


	public void setCylinderCapacity(double cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}


	public void setSeat(int seat) {
		this.seat = seat;
	}


	@Override
	public String toString() {
		return "\nCar ["+super.toString()+" cylinderCapacity=" + cylinderCapacity + ", seat=" + seat + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return super.equals(obj) && Double.doubleToLongBits(cylinderCapacity) == Double.doubleToLongBits(other.cylinderCapacity)
				&& seat == other.seat;
	}


	@Override
	public void input() {
		super.input();
		System.out.print("Nhập cylinder capacity: ");
		setCylinderCapacity(Double.parseDouble(sc.nextLine()));
		System.out.print("Nhập number of seat: ");
		setSeat(Integer.parseInt(sc.nextLine()));
		System.out.println();
	}

	
}
