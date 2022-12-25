package objects;

public class TestGeneral {

	public static void print(General g) {
		if( g instanceof Car) {
			System.out.println(((Car) g).getTechnical());
		}else if( g instanceof Animal) {
			System.out.println(((Animal) g).getInfor());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new TourCar();
		Animal a= new Cat();
		TestGeneral.print(c);
		TestGeneral.print(a);

	}

}
