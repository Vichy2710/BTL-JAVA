package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersonS implements Serializable {

	private static final long serialVersionUID =1L;
	static int count=0;
	int idPerson;
	PersonS next;
	public PersonS() {
		count++;
		this.idPerson = count;
		if(count<10) {
			next = new PersonS();
			
		}else {
			next=null;
		}
	}
	
	

	@Override
	public String toString() {
		return "PersonS [idPerson=" + idPerson + ", next=" + next + "]";
	}



	public static void main(String[] args) {
		try {
			// tao luong xuat
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("abc.txt"));
			// tao danh sach 10 doi tuong
			PersonS p = new PersonS();
			// ghi toan bo 10 doi tuong vao luong xuat
			out.writeObject(p);
			// dong luong xuat
			out.close(); 

			// ket noi luong doc
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("abc.txt"));
			// doc doi tuong
			PersonS p1= (PersonS) in.readObject();
			in.close();
			
			// duyet va in
//			while ((p1) !=null) {
//				System.out.println(p1);
//				p1=p1.next;
//			}
			do {
				System.out.println(p1);
			}while((p1=p1.next) !=null);
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
