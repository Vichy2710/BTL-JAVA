package util;

import objects.Person;
import java.util.*;
public class MyArrays {

	/**
	 * This method is used to generate n elements of array randomly
	 * 
	 * @param n
	 * @return
	 */
	public static int[] generateArray(int n) {
		int[] arrInt = new int[n];

		// sinh ngau nhien phan tu cua mang
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = (int) (Math.random() * 100);
		}

		return arrInt;
	}

	/**
	 * This method is used to generate a matrix
	 * 
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int[][] generateArray(int rows, int cols) {
		int[][] arrInt = new int[rows][cols];

		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = MyArrays.generateArray(cols);
		}

		return arrInt;
	}
	
	public static Person[] generatePerson(int n) {
		Person[] listPersons = new Person[n];
		
		// danh sách tên
		String[] firstNames = {
				"Anh","Anh Tuấn","Tuấn Anh"
				,"Minh Anh","Minh","Bảo","Minh Châu"
				,"Châu Anh","Hoàng","Huyền Anh","Bảo"
		};
		String[] lastNames = {
				"Hoàng","Lê","Vũ"
				,"Nguyễn","Đoàn","Nguyễn","Ngô"
				,"Lê","Trần","Bùi","Hồ"
		};
		
		// thực hiện sinh ngẫu nhiên danh sách
		int index;
		for(int i=0;i<n;i++) {
			// khởi tạo bộ nhớ cho phần tử mảng
			listPersons[i] = new Person();
			
			// sinh tên
			index = (int)(Math.random()*firstNames.length);
			listPersons[i].setFirstName(firstNames[index]);
			
			// sinh họ
			index = (int)(Math.random()*lastNames.length);
			listPersons[i].setLastName(lastNames[index]);
			
			// sinh tuổi
			index = 18+(int)(Math.random()*5);
			listPersons[i].setAge((byte)index);
			
		}
		return listPersons;
	}
	
	public static Person[] searchByName(Person[] listPersons, String name) {
		// dem so ket qua
		int count=0;
		for(Person p: listPersons) {
			if(p.getFirstName().contains(name)){
				count++;
			}
		}
		// khoi tao mang ket qua
		Person[] results = new Person[count];
		// ghi nhan ket qua
		count=0;
		for(Person p: listPersons) {
			if(p.getFirstName().contains(name)){
				results[count++]=p;
			}
		}
		return results;
	}
	
	public static ArrayList<Person> searchByNameV2(Person[]list, String name){
		// mang ket qua 
		ArrayList<Person> results = new ArrayList<>();
		for(Person p:list) {
			if(p.getFirstName().contains(name)) {
				results.add(p);
			}
		}
		
		return results;
	}

	/**
	 * This method is used to display array
	 * 
	 * @param arrInt
	 */
	public static void printArray(int[] arrInt) {
		for (int value : arrInt) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public static void printArray(int[][] arrInt) {
		for (int[] row : arrInt) {
			MyArrays.printArray(row);
		}
	}
	
	public static void printPerson(Person[] list) {
		for(Person p:list) {
			System.out.println(p);
		}
	}
	
	public static void printPerson(ArrayList<Person> list) {
		list.forEach(p->System.out.println(p));
	}
	

	/**
	 * This method is used to sort an array
	 * 
	 * @param arrInt
	 * @param isINC
	 * @return
	 */
	public static int[] sortedArray(int[] arrInt, boolean isINC) {
		// xác định hướng sắp xếp
		byte oriendted = (byte) (isINC ? 1 : -1);

		int tmp;
		for (int i = 0; i < arrInt.length - 1; i++) {
			for (int j = i + 1; j < arrInt.length; j++) {
				// oriented là biến để xác định tăng hay giảm
				if (arrInt[i] * oriendted > arrInt[j] * oriendted) {
					tmp = arrInt[i];
					arrInt[i] = arrInt[j];
					arrInt[j] = tmp;
				}
			}
		}

		return arrInt;
	}

	public static int[][] sortedArray(int[][] arrInt, boolean isINC) {
		// đưa mảng 2 chiều về 1 chiều
		int rows = arrInt.length;
		int cols = arrInt[0].length;
		int[] temp = new int[rows * cols];

		/*
		 * int tmpRows=0, tmpCols=0; for(int i=0;i<temp.length;i++) { temp[i] =
		 * arrInt[tmpRows][i%cols]; tmpRows = (i%cols==0)?tmpRows:++tmpRows; }
		 */

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				temp[i * cols + j] = arrInt[i][j];
			}
		}

		// sap xep
		temp = MyArrays.sortedArray(temp, isINC);

		// chuyen ve 2 chieu
		int row=0, col=0;
		for(int i=0;i<temp.length;i++) {
			arrInt[row][col++] = temp[i];
			if(i>0 && ((i+1) % cols)==0) {
				row++;
				col=0;
			}
		}

		return arrInt;

	}

	public static int[] filterPrime(int[] arrInt, boolean isINC) {
		// sort
		arrInt = MyArrays.sortedArray(arrInt, isINC);

		// tách nguyên tố, không nguyên tố (an toàn, nhưng không tối ưu)
		int[] temp1 = new int[arrInt.length]; // nguyên tố
		int[] temp2 = new int[arrInt.length]; // không nguyên tố

		int t1 = 0, t2 = 0;

		// ấn định rõ tham chiếu thay cho import package, class
		for (int value : arrInt) {
			if (exams.Example2.isPrime(value)) {
				temp1[t1++] = value;
			} else {
				temp2[t2++] = value;
			}
		}

		// Ghép lại
		for (int i = t1; i < temp1.length; i++) {
			temp1[i] = temp2[i - t1];
		}

		return temp1;
	}
	
	public static ArrayList<Person> sortedByAge(Person[] list, boolean isINC){
		// khai báo tập hợp trung gian
		ArrayList<Person> tmp = new ArrayList<>();
		// Chuyển mảng sang tập hợp List -> ArrayList
		Collections.addAll(tmp, list);
		// Sắp xếp
		if(isINC)
			Collections.sort(tmp);
		else {
			Collections.sort(tmp,Collections.reverseOrder());
		}
		// trả về kết quả
		return tmp;
		
	}
	public static ArrayList<Person> sortedByName(Person[] list, boolean isINC){
		// khai báo tập hợp trung gian
		ArrayList<Person> tmp = new ArrayList<>();
		// Chuyển mảng sang tập hợp List -> ArrayList
		Collections.addAll(tmp, list);
		// Sắp xếp
		if(isINC)
			Collections.sort(tmp, new sortedByName());
		else {
			Collections.sort(tmp, new sortedByName().reversed());
		}
		// trả về kết quả
		return tmp;
		
	}

	public static void main(String[] args) {

		/*
		 * // Generate array int[] arrInt = MyArrays.generateArray(20); // Print array
		 * MyArrays.printArray(arrInt);
		 * 
		 * // Sort arrInt = MyArrays.filterPrime(arrInt, true);
		 * 
		 * MyArrays.printArray(arrInt);
		 */

//		// sinh mảng
//		int[][] arrInt = MyArrays.generateArray(3, 6);
//		// in mảng
//		MyArrays.printArray(arrInt);
//		System.out.println();
//
//		MyArrays.sortedArray(arrInt, true);
//		MyArrays.printArray(arrInt);
		
		// sinh danh sach
		Person[] listPersons = MyArrays.generatePerson(10);
		// in mang
		//MyArrays.printPerson(listPersons);
		
		System.out.println("-----------------------------");
		// tim kiem
		//Person[] result = MyArrays.searchByName(listPersons, "Anh");
		
		ArrayList<Person> results = MyArrays.sortedByName(listPersons, true);
		MyArrays.printPerson(results);
		
	}

}

// inner class
class sortedByName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		String name1 = o1.getFirstName();
		String name2 = o2.getFirstName();
		
		// vị trí cắt lấy tên
		byte at = (byte)name1.lastIndexOf(" ");
		if(at!=-1) {
			name1 = name1.substring(at+1);
		}
		at =(byte) name2.lastIndexOf(" ");
		if(at!=-1) {
			name2 = name2.substring(at+1);
		}
		return name1.compareToIgnoreCase(name2);
	}
	// sap xep mang nhieu dieu kien
//	ArrayList<Person> tmPersons = new ArrayList<>();
//	Comparator<Person> condsComparator = Comparator.comparing(Person::getFirstName)
//			.thenComparing(Person::getLastName);
//	tmp.sort(conds);
}
