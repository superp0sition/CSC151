package Lab15a;

/**
 * Write a tester program to test Bicycle and Dragster objects.  Use declarations such as
 *   Vehicle b = new Bicycle();
 * in your tester.
 */

public class Tester {

	public static void main(String[] args) {
		Vehicle bicycle = new Bicycle("Electric"); // I'm not sure that I understand this problem. You ask for a default constructor in the child classes but not in the parent class, so one cannot exist.
		System.out.println(bicycle.getVehicleType());
		for(Tire t : bicycle.getTires()) {
			System.out.println(t.getSize());
		}

		Vehicle dragster = new Dragster("TopFuel");
		System.out.println(dragster.getVehicleType());
		for(Tire t : dragster.getTires()) {
			System.out.println(t.getSize());
		}
	
	}

}
