package exams;

public class Example3 {
	
	/**
	 * 
	 * This method is used to check whether 3 parameters are a triangle
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return true/false
	 */
	public static boolean isTriangle(int a, int b, int c) {
		if(a+b>c && a+c>b && b+c>a && a>0 && b>0 && c>0)
			return true;
		else
			return false;
		
	}
	
	/**
	 * This method is used to display what type of triangle
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public static void typeOfTriangle(int a, int b, int c) {
		if(Example3.isTriangle(a,b,c)) {
			if(a==b && b==c)
				System.out.println(a+", "+b+", "+c+" la 3 canh cua tam giac deu");
			else if(((a*a + b*b == c*c) || (b*b + c*c == a*a) || (a*a + c*c == b*b)) && (a==b || b==c || a==c)) 
				System.out.println(a+", "+b+", "+c+" la 3 canh cua tam giac vuong can");
			else if((a*a + b*b == c*c) || (b*b + c*c == a*a) || (a*a + c*c == b*b))
				System.out.println(a+", "+b+", "+c+" la 3 canh cua tam giac vuong ");
			else if (a==b || b==c || a==c)
				System.out.println(a+", "+b+", "+c+" la 3 canh cua tam giac can ");
			else
				System.out.println(a+", "+b+", "+c+" la 3 canh cua tam giac thuong ");
		}else
			System.out.println(a+", "+b+", "+c+" khong la 3 canh cua tam giac ");
	}
	public static void main(String[] args) {
		int a = (int)(Math.random()*100);
		int b = (int)(Math.random()*100);
		int c = (int)(Math.random()*100);

		Example3.typeOfTriangle(a, b, c);
	}
}
