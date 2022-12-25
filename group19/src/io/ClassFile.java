package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import util.MyStrings;
import java.util.Random;
import java.util.Scanner;

public class ClassFile {
	public static Scanner scanner = new Scanner(System.in);

	public static void WriteStudentToFile(ArrayList<Student> list, String filename) throws IOException,ClassNotFoundException, FileNotFoundException {
		FileOutputStream f = new FileOutputStream(new File(filename));
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		o.writeBytes(String.format("\n%-5s|%-27s|%-10s\n", "STT","Ho ten","Tuoi"));
		// write each element in list into file
		for(int i=0;i<list.size();i++) {
			o.writeBytes(String.format("%-5d|%-27s|%-10d", i+1,list.get(i).getName(),list.get(i).getAge()));
			o.writeBytes("\n");
		}
		o.writeBytes("Tong so hoc sinh: "+list.size());
		o.close(); 
		f.close();
	}
	public static void ReadStudentFromFile(String fileName) throws IOException {
		FileInputStream f = new FileInputStream(new File(fileName));
		ObjectInputStream o = new ObjectInputStream(f);
		
		// read file
		int tmp=0;
		while((tmp=f.read())!=-1) {
			System.out.print((char)tmp);
		}
		
		o.close(); 
		f.close();
	}
	
	public static void WriteNamesToFile(ArrayList<Student> list, String filename) throws IOException,ClassNotFoundException, FileNotFoundException {
		FileOutputStream f = new FileOutputStream(new File(filename));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeBytes("\n");
		// write each element in list into file
		for(int i=0;i<list.size();i++) {
			o.writeBytes(list.get(i).getName()+"\n");
			
		}
		o.close(); 
		f.close();
	}
	public static void ReadNamesFromFile(String fileName) throws IOException {
		FileInputStream f = new FileInputStream(new File(fileName));
		ObjectInputStream o = new ObjectInputStream(f);
		
		// read file
		int tmp=0;
		while((tmp=f.read())!=-1) {
			System.out.print((char)tmp);
		}
		
		o.close(); 
		f.close();
	}
	
	public static void WriteAgesToFile(ArrayList<Student> list, String filename) throws IOException,ClassNotFoundException, FileNotFoundException {
		FileOutputStream f = new FileOutputStream(new File(filename));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeBytes("\n");
		// write each element in list into file
		for(int i=0;i<list.size();i++) {
			o.writeBytes(list.get(i).getAge()+"\n");
			
		}
		o.close(); 
		f.close();
	}
	public static void ReadAgesFromFile(String fileName) throws IOException {
		FileInputStream f = new FileInputStream(new File(fileName));
		ObjectInputStream o = new ObjectInputStream(f);
		
		// read file
		int tmp=0;
		while((tmp=f.read())!=-1) {
			System.out.print((char)tmp);
		}
		
		o.close(); 
		f.close();
	}
//	public static ArrayList<String> filterName(ArrayList<Student> list){
//		ArrayList<String> names = new ArrayList<>();
//		for(int i=0;i<list.size();i++) {
//			names.add(list.get(i).getName());
//		}
//		return names;
//		
//	}
//	
//	public static ArrayList<Integer> filterAge(ArrayList<Student> list){
//		ArrayList<Integer> ages = new ArrayList<>();
//		for(int i=0;i<list.size();i++) {
//			ages.add(list.get(i).getAge());
//		}
//		return ages;
//		
//	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ArrayList<Student> students = new ArrayList<>();
		System.out.print("Nhap so sinh vien trong lop: ");
		int n = scanner.nextInt();
		// sinh ngau nhien phan tu cua mang
		for (int i = 0; i<n;i++) {
			Student tmpStudent= new Student();
			//random age
			tmpStudent.setAge((int) (Math.random() * 100));
			//random name
			int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 25;
		    Random random = new Random();

		    String generatedString = MyStrings.formatUpper(
		    		random.ints(leftLimit, rightLimit + 1)
				      .limit(targetStringLength)
				      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				      .toString()
		    		);
		    tmpStudent.setName(generatedString);
		    students.add(tmpStudent);
		}
		
		 //in mang ra man hinh console
//		System.out.println(String.format("%-5s|%-27s|%-10s", "STT","Ho ten","Tuoi"));
//		for(int i=0;i<n;i++) {
//			System.out.println(String.format("%-5d|%-27s|%-10d", i+1,students.get(i).getName(),students.get(i).getAge()));
//			
//		}
//		System.out.println();
		
		//original list
		WriteStudentToFile(students,"OriginalFile.txt");
		System.out.println("Du lieu tu file: \n");
		ReadStudentFromFile("OriginalFile.txt");
		
		// filtered name file
		WriteNamesToFile(students,"FilterName.txt");
		System.out.println("\nTen: ");
		ReadNamesFromFile("FilterName.txt");
		// filtered age file
		WriteAgesToFile(students,"FilterAge.txt");
		System.out.println("\nTuoi: ");
		ReadAgesFromFile("FilterAge.txt");
		
		// sort list
		students.sort((o1, o2)
                -> o1.getName().compareTo(
                    o2.getName()));
		WriteStudentToFile(students,"SortedFile.txt");
		System.out.println("\nFile da sap xep: \n");
		ReadStudentFromFile("SortedFile.txt");
		
	}

}
