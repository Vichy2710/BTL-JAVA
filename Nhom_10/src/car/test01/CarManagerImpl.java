package car.test01;

import java.util.*;

public class CarManagerImpl implements CarManager {
	static Scanner sc = new Scanner(System.in);
	
	private List<Car> list = new ArrayList<Car>();
	
	public List<Car> getList() {
		return list;
	}

	public void setList(List<Car> list) {
		this.list = list;
	}
	
	private String createName() {
		String[] name = {
				"Honda", "Toyota", "Lexus", "Suzuki", "Bentley", "Randrover",
				"Roll-Royce", "Huyndai", "Kia", "Ford", "Chryler", "BMW",
				"Mercedes-benz"
		};
		return name[(int)(Math.random() *name.length )];
	}
	
	private double createPrice() {
		return (double)Math.round(((Math.random() * (10_000 - 1_000 + 1)) + 1_000 ) * 100) / 100 ;
	}
	

	private int createTotal() {
		return (int)(Math.random() * 5000);
	}
	
	private double createCylinder() {
		return (double)Math.round((((Math.random() * (8 - 2 + 1)) + 2) * 10)) / 10 ;
	}
	
	private int createSeat() {
		return (int)((Math.random() * (4-1))+1);
	}

	public void init(int n) {
		for(int i = 1; i <= n; i++) {
			list.add(new Car(list.size()+1,	createName(),createPrice() , createTotal(), createCylinder(), createSeat()));
		}
	}

	@Override
	public boolean addCar(Car c) {
		System.out.println("Nhập thông tin xe cần thêm");
		c.input();
		for (Car car : list) {
			if(car.equals(c))
				return false;
		}
		c.setProduct_id(list.size()+1);
		list.add(c);
		return true;
	}

	@Override
	public boolean editCar(Car c) {
		System.out.print("\nNhập product_id: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCar(id);
		if(index < 0)
			return false;
		System.out.println("\nNhập thông tin mới của xe: ");
		c.input();
		c.setProduct_id(list.get(index).getProduct_id());

		list.set(index, c);
		return true;
	}

	@Override
	public boolean delCar(Car c) {
		System.out.print("\nNhập product_id: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCar(id);
		if(index < 0)
			return false;
		list.remove(list.get(index));
		return true;
	}

	@Override
	public List<Car> searchCar(String name) {
		List<Car> tmp = new ArrayList<Car>();
		for (Car car : list) {
			if(car.getProduct_name().compareToIgnoreCase(name) == 0) {
				tmp.add(car);
			}
		}
		return tmp;
	}
	
	@Override
	public List<Car> searchCar(double price) {
		List<Car> tmp = new ArrayList<Car>();
		for (Car car : list) {
			if(car.getProduct_price() == price) {
				tmp.add(car);
			}
		}
		return tmp;
	}
	
	@Override
	public List<Car> searchCar(int total) {
		List<Car> tmp = new ArrayList<Car>();
		for (Car car : list) {
			if(car.getProduct_total() == total) {
				tmp.add(car);
			}
		}
		return tmp;
	}
	
	@Override
	public List<Car> searchCarByCylinder(double cylinderCapacity) {
		List<Car> tmp = new ArrayList<Car>();
		for (Car car : list) {
			if(car.getCylinderCapacity() == cylinderCapacity) {
				tmp.add(car);
			}
		}
		return tmp;
	}
	
	@Override
	public List<Car> searchCarBySeat(int seat) {
		List<Car> tmp = new ArrayList<Car>();
		for (Car car : list) {
			if(car.getSeat() == seat) {
				tmp.add(car);
			}
		}
		return tmp;
	}

	@Override
	public List<Car> sortedCar(double price, boolean isINC) {
		List<Car> tmp = new ArrayList<Car>();
		for (Car car : list) {
			if(car.getProduct_price() >= price)
				tmp.add(car);
		}
		if(isINC)
			Collections.sort(tmp, new sortedByPrice());
		else 
			Collections.sort(tmp, new sortedByPrice().reversed());
		return tmp;
		
	}
	
	@Override
	public List<Car> sortedCarByCylinder(double cylinder, boolean isINC) {
		List<Car> tmp = new ArrayList<Car>();
		for (Car car : list) {
			if(car.getCylinderCapacity() >= cylinder)
				tmp.add(car);
		}
		if(isINC)
			Collections.sort(tmp, new sortedByCylinderCapacity());
		else 
			Collections.sort(tmp, new sortedByCylinderCapacity().reversed());
		return tmp;
	}
	
	@Override
	public String toString() {
		return "TestProduct [list=" + list + "]";
	}
	
	public int indexOfCar(int id) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getProduct_id() == id)
				index = i;
		}
		return index;
	}


}

class sortedByPrice implements Comparator<Car> {
	@Override
	public int compare(Car o1, Car o2) {
		return (int) (o1.getProduct_price() - o2.getProduct_price());
	}
	
}

class sortedByCylinderCapacity implements Comparator<Car> {
	@Override
	public int compare(Car o1, Car o2) {
		return (int)(o1.getCylinderCapacity() * 10 - o2.getCylinderCapacity() * 10);
	}
	
}


