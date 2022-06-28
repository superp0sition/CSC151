package Lab13B;

public class Classroom extends Room {

	/**
	 * An int instance variable for the number of chairs in the classroom
	 */

	private int chairs = 0;

	// Default constructor

	Classroom() {

	}

	/**
	 * Constructor that takes the area of the classroom as a parameter.
	 * 
	 * @param area - Area of the classroom
	 */

	Classroom(int area) {
		super.setSquareFeet(area);
	} //changed this

	/**
	 * Constructor that takes the area of the classroom and the number of chairs as
	 * parameters.
	 * 
	 * @param area   - Area of the classroom
	 * @param chairs - Number of chairs
	 */

	Classroom(int area, int chairs) {
		this.setSquareFeet(area);
		this.setChairs(chairs);

	}

	// getter and setter for chairs

	public int getChairs() {
		return chairs;
	}

	public void setChairs(int chairs) {
		this.chairs = chairs;
	}

	/**
	 * An override for getCapacity(). Accessor, int getCapacity(): The capacity of a
	 * classroom is the number of chairs.
	 */

	@Override
	public int getCapacity() {
		return this.getChairs();
	}

	/**
	 * Returns the square feet and capacity of the room as well as the number of
	 * chairs.
	 */

	public String toString() {
		return "Classroom: "+ super.toString();
	}
}
