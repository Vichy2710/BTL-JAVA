package exams;

import java.util.Scanner;

public class Example4 {

	// declare variables
	public static final float pi = 3.14f;
	
	/**This method is used to get volume of a cone
	 * 
	 * @param r
	 * @param h
	 * @return 
	 */
	public static float coneVolume (float r, float h) {
		return (float) ((1.0 * 1/3) * pi * r*r *h);
	}
	
	/**This method is used to get volume of a cylinder
	 * 
	 * @param r
	 * @param h
	 * @return 
	 */
	public static float coneCylinder (float r, float h) {
		return 3*coneVolume(r, h);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		float r = input.nextFloat();
		float h = input.nextFloat();
		
		System.out.println("The tich hinh non co r = "+r+" va h = "+h+" la: " + coneVolume(r, h));
		System.out.println("The tich hinh tru co r = "+r+" va h = "+h+" la: " + 3*coneVolume(r, h));
	}

}
