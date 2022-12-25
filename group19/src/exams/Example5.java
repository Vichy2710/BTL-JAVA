package exams;

import java.util.Scanner;

public class Example5 {

	/**
	 * This method is used to get factorial of a number
	 * @param n
	 * @return
	 */
	public static long factorial(int n) {
		if(n==1||n==0)
			return 1;
		else {
			return n*factorial(n-1);
		}
	}
	
	/**
	 * this method is used to get the number of arrangements of n objects taken k
	 * @param n
	 * @param k
	 * @return
	 */
	public static long arrangement(int n, int k) {
		return factorial(n)/factorial(n-k);
	}
	
	/**
	 * this method is used to get the number of combinations of n objects taken k of 
	 * @param n
	 * @param k
	 * @return
	 */
	public static long combination(int n, int k) {
		return factorial(n) / (factorial(k)*factorial(n-k));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int n,k;
		System.out.print("Nhap so phan tu cua tap A: ");
		n = input.nextInt();
		System.out.print("Nhap so phan tu trong mot set: ");
		k = input.nextInt();
		
		System.out.println("Chinh hop chap k cua n la: "+arrangement(n, k));
		System.out.println("To hop chap k cua n la: "+combination(n, k));
	}

}
