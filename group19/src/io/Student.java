package io;

import java.io.Serializable;
import java.util.Comparator;

public class Student implements Serializable {

	// properties 
	String name;
	int age;
	
	public Student() {}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {

		

	}

}
