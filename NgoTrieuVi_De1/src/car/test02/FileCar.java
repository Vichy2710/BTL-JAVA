package car.test02;

import java.io.*;
import java.util.*;

import car.test01.Car;

public class FileCar {
	public static void outputList(List<Car> list) throws IOException {
			FileOutputStream outFile = new FileOutputStream("Car.bin");
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeInt(list.size());
			for (Car car : list) {
				out.writeObject(car);
			}

			out.close();
	}
	
	public static List<Car> inputList( int n) throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("Car.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		in.readInt();
		List<Car> list = new ArrayList<>();
		for(int i = 0 ; i < n; i++) {
			list.add((Car)in.readObject());
		}
		in.close();
		return list;
	}
	
	public static int sizeList() throws IOException, ClassNotFoundException{
		FileInputStream inputFile = new FileInputStream("Car.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);
		
		int size = in.readInt();
		inputFile.close();
		in.close();
		return size;
	}
	
	public static List<Car> InOutFile(List<Car> list) throws IOException, ClassNotFoundException {
		outputList(list);
		list = inputList(sizeList());
		return list;
	}
}
