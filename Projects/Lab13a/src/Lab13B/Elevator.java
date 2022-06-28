package Lab13B;

public class Elevator extends Room {

	/**
	 * An int instance variable for the current floor of the elevator
	 */

	private int currentFloor = 0;

	// A getter for floor
	public int getCurrentFloor() {
		return currentFloor;
	}

	// Default Constructor
	public Elevator() { // changed

	}

	/**
	 * Constructor that takes the area of the elevator as a parameter
	 * 
	 * @param area - Area of the elevator
	 */
	public Elevator(int area) { // changed
		super.setSquareFeet(area);
	}

	/**
	 * Mutator void up(int floors) that increases the current floor by the parameter
	 * 
	 * @param floors - Increases the current floor.
	 */
	public void up(int floors) {
		this.currentFloor += floors;
	}

	/**
	 * Mutator void down(int floors) decreases the current floor by the parameter
	 * 
	 * @param floors - Decreases the current floor.
	 */

	public void down(int floors) {
		this.currentFloor -= floors;
	}

	/**
	 * Accessor String toString() that returns the square feet and capacity of the
	 * elevator, as well as its current floor.
	 *
	 * @return a string describing elements of the elevator
	 */
	public String toString() {
		return "Elevator: "+ super.toString() +", and the current floor is " + this.getCurrentFloor();
	}
}
