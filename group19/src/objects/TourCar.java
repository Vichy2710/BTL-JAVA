package objects;

import java.util.ArrayList;

public class TourCar extends Car {

	@Override
	public ArrayList<String> getTechnical() {
		// TODO Auto-generated method stub
		
		ArrayList<String> tmp = new ArrayList<>();
		tmp.add("Vinfast");
		tmp.add("Kia");
		tmp.add("Hyundai");
		return tmp;
	}

}
