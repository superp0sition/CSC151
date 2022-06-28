package ProjectCarLot;

public class CarTester {
    public static void main(String[] args){
        try{
            // Instantiate at least 2 Car objects
            // Ensure that both constructors work as specified. This is especially important for the constructor used to add a new Car to the inventory
            Car[] cars = {new Car("test1", 10000, 30, 12500, 17500), new Car("test2", 15000, 40, 15000, 19000), new Car()};

            // Ensure that the sellCar() method works properly
            cars[0].sellCar(18000);
            cars[1].sellCar(21000);

            for(Car c : cars)
                System.out.println(c);

            //Test each of the Compare methods above by creating two Car objects and verifying that each possible return value (negative number, zero, or positive number) is generated as expected
            for(Car c : cars)
                System.out.printf("\nComparing to: %7s | compareMPG=%d compareMiles=%d comparePrice=%d\n",c.getId(),cars[0].compareMPG(c),cars[0].compareMiles(c),cars[0].comparePrice(c));
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}