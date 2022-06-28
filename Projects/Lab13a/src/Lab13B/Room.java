package Lab13B;

public class Room {

	/**
	 * An int instance variable for the area (in square feet) of the room
	 */
	private int area = 0;

	// Default constructor

	Room() {

	}

	/**
	 * Constructor that takes the area of the room as a parameter.
	 * 
	 * @param area - area of the room
	 */
	Room(int area) {
		this.setSquareFeet(area);
	}

	/**
	 * Accessor - int getSquareFeet()
	 * 
	 * @return The area of the room.
	 */
	public int getSquareFeet() {
		return this.area;
	}

	/**
	 * Mutator, setSquareFeet(int area)
	 * 
	 * @param area - Sets the square feet of the room
	 */
	public void setSquareFeet(int area) {
		this.area = area;
	}

	/**
	 * Accessor, int getCapacity(): The capacity is given by dividing the square
	 * feet by 9 (using integer division).
	 * 
	 * @return - The capacity of the room.
	 */
	public int getCapacity() {
		return this.getSquareFeet()/9;
	}

	/**
	 * Accessor, String toString(). Returns the square feet and capacity of the
	 * room.
	 * 
	 */
	public String toString() {
		return "Square feet is: " + this.getSquareFeet() + " and capacity of the room is: " + this.getCapacity();

	}

}
