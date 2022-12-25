package exams;

public class Example2 {
	
	/**
	 * This method is used to check a value <b>is Prime</b>?<br>
	 * 
	 * <i> Update 22/09/20022 </i>
	 * 
	 * @author Ngo Trieu Vi
	 * 
	 * @param n
	 * @return true/false
	 */
	public static boolean isPrime(int n) {
		boolean flag = true;
		if(n<2) {
			flag=false;
		}else {
			for(int value = 2; value<=(int)(Math.sqrt(n)); value++) {
				if(n%value == 0) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * This method is used to find <b>Greatest Common Divisor</b> of 2 parameters<br>
	 * 
	 * <i> Update 22/09/20022 </i>
	 * 
	 * @author Ngo Trieu Vi
	 * @param a
	 * @param b
	 * @return GCD
	 */
	public static int getGCD(int a, int b) {
		int gcd = -1;
		
		if(a*b !=0) {
			while(a!=b) {
				if(a>b) {
					a-=b;
				}else {
					b-=a;
				}
			}
			gcd =a; //b
			
		}
		
		return gcd;
		
	}
	
	/**
	 * This method is used to find <b>Greatest Common Divisor</b> of 2 parameters<br>
	 * 
	 * <b>overloading</b><br>
	 * <i> Update 22/09/20022 </i>
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int getGCD(int a, int b, int c) {
	
		return Example2.getGCD(Example2.getGCD(a, b),c);
	}
	
	public static void main(String[] args) {
		// Khởi tạo đối tượng
		// Example2 ex2 = new Example2();
		
		int n = (int)(Math.random()*100);
		
		int m = (int)(Math.random()*100);
		
		// kiểm tra so nguyen to
		// boolean result = ex2.isPrime(n);
		
		// thông báo
//		if(Example2.isPrime(n)) { // khởi tạo trực tiếp đối tượng
//			System.out.print("Giá trị của n = "+n+" là số nguyên tố");
//		}else {
//			System.out.print("Giá trị của n = "+n+" không là số nguyên tố");
//		}
		
		// tim uoc chung lon nhat
		System.out.print("UCLN cua n = "+n+" va m = "+m+" la "+Example2.getGCD(n, m));
	}

}
