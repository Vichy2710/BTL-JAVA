package report;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import car.account.*;
import car.test01.*;
import car.test02.*;
import mobile.*;
import tour.*;
public class Statistical {
	private static List<Car> listCar; 
	private static List<Mobile> listMobile; 
	private static List<Tour> listTour; 
	
	public static void writeFile(String file) {
		try { 
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			if(file.equals("Car1.bin")) {
				List<Car> list1 = new ArrayList<Car>(); 
				list1.add(new Car(list1.size()+1, "Ford", 23.3, 34, 2.0, 10));
				list1.add(new Car(list1.size()+1, "Honda", 12, 12, 3.5, 13));
				list1.add(new Car(list1.size()+1, "Huyndai", 45.6, 45, 1.0, 23));
				list1.add(new Car(list1.size()+1, "Honda", 18, 56, 8.0, 5));
				list1.add(new Car(list1.size()+1, "Mazda", 16.7, 23, 3.0, 14));
				list1.add(new Car(list1.size()+1, "Honda", 46.8, 12, 4.0, 15)); 
				out.writeObject(list1); 
			}else if(file.equals("Mobile1.bin")) {
				List<Mobile> list1 = new ArrayList<Mobile>(); 
				list1.add(new Mobile(list1.size()+1+"", "iPhone11", 23.3, 34, "Apple", 78.5, 64));
				list1.add(new Mobile(list1.size()+1+"", "Vivo X80", 12, 12, "Vivo", 90, 120));
				list1.add(new Mobile(list1.size()+1+"", "Samsung Galaxy S22", 45.6, 45, "Samsung", 100, 128));
				list1.add(new Mobile(list1.size()+1+"", "iPhone13 Pro", 18, 56, "Apple", 100, 128));
				list1.add(new Mobile(list1.size()+1+"", "Oppo Find X5", 16.7, 23, "Oppo", 100, 136));
				list1.add(new Mobile(list1.size()+1+"", "Vivo X80", 50, 45, "Vivo", 100, 140)); 
				out.writeObject(list1); 
			}else if(file.equals("Tour1.bin")) {
				List<Tour> list1 = new ArrayList<Tour>(); 
				list1.add(new Tour(list1.size()+1+"", "Sinh thai", 23.3, 34L, "Đa Nang", 10.1));
				list1.add(new Tour(list1.size()+1+"", "Van hoa", 12.0, 12L,  "Hue",  4.1));
				list1.add(new Tour(list1.size()+1+"", "Nghi duong", 45.6, 45L,  "Hoi An",  5.0));
				list1.add(new Tour(list1.size()+1+"", "Giai tri", 18.0, 56L,  "Nha Trang", 7.0));
				list1.add(new Tour(list1.size()+1+"", "Kham pha", 16.7, 23L, "Ha Noi",  8.0));
				list1.add(new Tour(list1.size()+1+"", "Van hoa", 12.0, 47L,  "Hue", 8.0));
				out.writeObject(list1); 
			}
			out.close(); 
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void readFile(String file) {
		try {
			FileInputStream fin = new FileInputStream(file); 
			ObjectInputStream in = new ObjectInputStream(fin); 
			if(file.equals("Car1.bin")) {
				listCar = (ArrayList<Car>) in.readObject(); 
			} else if(file.equals("Mobile1.bin")) {
				listMobile = (ArrayList<Mobile>) in.readObject(); 
			} else if(file.equals("Tour1.bin")){
				listTour = (ArrayList<Tour>) in.readObject(); 
			}
			in.close(); 
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static List<Car> getListCar() {
		return listCar;
	}

	public static void setListCar(List<Car> listCar) {
		Statistical.listCar = listCar;
	}

	public static List<Mobile> getListMobile() {
		return listMobile;
	}

	public static void setListMobile(List<Mobile> listMobile) {
		Statistical.listMobile = listMobile;
	}

	public static List<Tour> getListTour() {
		return listTour;
	}

	public static void setListTour(List<Tour> listTour) {
		Statistical.listTour = listTour;
	}
}
