package ProjectCarLot;

public class CarLotTester {
    public static void main(String[] args){
        CarLot lot = new CarLot();

        try{
            // Test that the addCar() and sellCar() methods work as expected
            lot.addCar("Help", 5000, 30, 10000, 18000);
            lot.addCar("Me", 10000, 20, 13000, 20000);

            lot.sellCar("Help", 30000);

            // Verify that the accessor methods work as expected by creating a CarLot  with an inventory of at least 2 Cars. Your code should call the appropriate accessor and if the correct Car is not returned, print an error message on the Console
            System.out.println("Profit: " + lot.getTotalProfit());
            System.out.println("Car \"Me\": " + lot.findCarByIdentifier("Me"));
            System.out.println("Sorted Car List: " + lot.getCardsSortedByMPG().toString());
            System.out.println("Original Car List: " + lot.getCarsInOrderOfEntry());
            System.out.println("Car with best MPG: " + lot.getCarWithBestMPG());
            System.out.println("Average MPG of cars in the lot: " + lot.getAverageMpg());
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}

