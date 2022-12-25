package io;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

import objects.*;
import util.MyArrays;

public class MyFile {

	public static void textOutputFile() throws IOException {
		// tao doi tuong file de luu du lieu
		FileWriter outFileWriter = new FileWriter("ABC1.txt");
		// tao doi tuong thuc hien xuat noi dung
		PrintWriter out = new PrintWriter(outFileWriter);
		// xuat noi dung
		out.println(12345);
		out.println("LỚP IT6019");
		out.println(199.89);
		out.println(false);
		// dong file
		out.close();
	}

	public static void textInputFile() throws IOException {
		// xac dinh doi tuong file de doc
		FileReader inFileReader = new FileReader("ABC.txt");
		// nap du lieu vao bo dem doc
		BufferedReader in = new BufferedReader(inFileReader);

		// khai bao cac bien
		String tmpStr;
		int anInt;
		double aDouble;
		boolean aBoolean;
		tmpStr = in.readLine();
		anInt = Integer.parseInt(tmpStr);
		System.out.println(anInt);

		tmpStr = in.readLine();
		System.out.println(tmpStr);

		tmpStr = in.readLine();
		aDouble = Double.parseDouble(tmpStr);
		System.out.println(aDouble);

		tmpStr = in.readLine();
		aBoolean = Boolean.parseBoolean(tmpStr);
		System.out.println(aBoolean);

		in.close();
	}

	public static void binaryOutputFile(short n) throws IOException {
		// xac dinh doi tuong tap tin nhi phan de xuat noi dung
		FileOutputStream outFile = new FileOutputStream("abc.bin");
		// Khai bao doi tuong thuc thi xuat
		ObjectOutputStream out = new ObjectOutputStream(outFile);

		// sinh ngau nhien danh sach
		Person[] list = MyArrays.generatePerson(n);
		for (int i = 0; i < n; i++) {
			out.writeInt(i + 1);
			out.writeObject(list[i]);
		}
		out.close();
		outFile.close();
	}

	public static void binaryInputFile(short n) throws IOException, ClassNotFoundException {
		// xac dinh doi tuong tap tin nhi phan de xuat noi dung
		FileInputStream inFile = new FileInputStream("abc.bin");
		// Khai bao doi tuong thuc thi xuat
		ObjectInputStream in = new ObjectInputStream(inFile);

		for (int i = 0; i < n; i++) {
			System.out.printf("%-3d", in.readInt());
			System.out.println(in.readObject());
		}
		in.close();
		inFile.close();
	}

	public static long sortOutputFile(short n) throws IOException, ClassNotFoundException {
		// xac dinh doi tuong tap tin nhi phan de xuat noi dung
		FileInputStream inFile = new FileInputStream("abc.bin");
		// Khai bao doi tuong thuc thi xuat
		ObjectInputStream in = new ObjectInputStream(inFile);

		ArrayList<Person> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			in.readInt();
			list.add((Person) in.readObject());
		}
		in.close();
		inFile.close();

		// sort list
		Collections.sort(list);

		RandomAccessFile raf = new RandomAccessFile("abc.bin", "rw");

		// di chuyen xuong cuoi file
		raf.seek(raf.length());
		long pos = raf.length();// xac dinh vi tri bat dau ghi
		list.forEach(item -> {
			try {
				raf.writeUTF(item.toString() + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return pos;
	}

	public static void sortInputFile(short n, long pos) throws IOException, ClassNotFoundException {
		// xac dinh doi tuong tap tin nhi phan de xuat noi dung
		FileInputStream inFile = new FileInputStream("abc.bin");
		// Khai bao doi tuong thuc thi xuat
		ObjectInputStream in = new ObjectInputStream(inFile);

		for (int i = 0; i < n; i++) {
			System.out.printf("%-3d", in.readInt());
			System.out.println(in.readObject());
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(in.readUTF());
//		}
//		in.close();
//		inFile.close();

		RandomAccessFile raf = new RandomAccessFile("abc.bin", "rw");
		// di chuyen xuong cuoi file
		raf.seek(pos);
		for (int i = 0; i < n; i++) {
			System.out.println(raf.readUTF());
		}
		raf.close();

	}

	public static void main(String[] args) throws IOException {
//		MyFile.textOutputFile();
//		MyFile.textInputFile();

		try {
			MyFile.binaryOutputFile((short) 20);
			
			MyFile.sortInputFile((short) 20,MyFile.sortOutputFile((short) 20));
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
