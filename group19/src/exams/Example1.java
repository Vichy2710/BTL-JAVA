package exams;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// sinh ngẫu nhiên 1 giá trị nguyên (int) trong phạm vi [0-100)
		int n = (int)(Math.random()*100); // vì random() trả về giá trị trong đoạn [0.0-1.0)
		
		System.out.print("Giá trị của n = " + n);
		
		// kiểm tra số nguyên tố
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
		
		// thông báo kết quả
		if(flag) {
			System.out.println(" là nguyên tố");
		}else {
			System.out.println(" không là nguyên tố");
		}

	}

}
