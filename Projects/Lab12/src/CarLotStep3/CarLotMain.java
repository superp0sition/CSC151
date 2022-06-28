package CarLotStep3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CarLotMain {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        CarLot lot = new CarLot();
        int input = -1;
        while(input != 0) {
            // took the menu from the prompt
            System.out.print("""
                    
                    [0] Exit
                    [1] Add a car to inventory
                    [2] Sell a car from inventory
                    [3] List inventory by order of acquisition
                    [4] List Inventory From Best MPG to Worst MPG
                    [5] Display car with best MPG
                    [6] Display car with the highest mileage
                    [7] Display overall MPG for the entire inventory
                    [8] Display profit for all sold cars
                    Enter a number from 0 to 8:\s"""); // text block was a nice recommendation from ide
            System.out.println();

            input = s.nextInt();
            try {
                switch (input) {
                    case 1: // add a car
                        System.out.print("Enter an identifier for the car: ");
                        String id = s.next();
                        System.out.print("Enter the miles on the odometer: ");
                        int miles = s.nextInt();
                        System.out.print("Enter the car's MPG: ");
                        int mpg = s.nextInt();
                        System.out.print("Enter the purchase price of the car: ");
                        double cost = s.nextDouble();
                        System.out.print("Enter the requested listing price: ");
                        double sales = s.nextDouble();
                        lot.addCar(id, miles, mpg, cost, sales);
                        break;
                    case 2: // sell a car
                        System.out.print("Which car are you selling? ");
                        String idSold = s.next();
                        System.out.print("What price is it selling at? ");
                        lot.sellCar(idSold, s.nextDouble());
                        break;
                    case 3:// list cars by acquisition
                        System.out.println("Car list by order of acquisition: " + lot.getCarsInOrderOfEntry());
                        break;
                    case 4: // list sorted by mpg best to worst
                        ArrayList<Car> sortedListDescending = lot.getCardsSortedByMPG();
                        Collections.reverse(sortedListDescending);
                        System.out.println("Sorted Car List: " + sortedListDescending);
                        break;
                    case 5: // best mpg
                        System.out.println("Car with best MPG: " + lot.getCarWithBestMPG());
                        break;
                    case 6: // highest milage
                        System.out.println("Car with best mileage: " + lot.getCarWithHighestMileage());
                        break;
                    case 7: // average mpg
                        System.out.println("Average MPG of cars in the lot: " + lot.getAverageMpg());
                        break;
                    case 8: // step 1 ??? step 2 profit
                        System.out.println("Profit: " + lot.getTotalProfit());
                        break;
                } // never knew this was a way to write switch cases in java
            } catch (IllegalArgumentException e){
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) { // wasn't sure if there were any other messages I should add at this point
                System.err.println("Error: " + e);
            }

        }
    }
}
