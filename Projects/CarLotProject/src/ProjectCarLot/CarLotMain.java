package ProjectCarLot;

import javax.swing.*;

public class CarLotMain {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }

    private static void createGUI(){
        CarLotMainUI ui = new CarLotMainUI();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

// original code

/*
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
            System.out.print("\n" +
                             "[0] Exit\n" +
                             "[1] Add a car to inventory\n" +
                             "[2] Sell a car from inventory\n" +
                             "[3] List inventory by order of acquisition\n" +
                             "[4] List Inventory From Best MPG to Worst MPG\n" +
                             "[5] Display car with best MPG\n" +
                             "[6] Display car with the highest mileage\n" +
                             "[7] Display overall MPG for the entire inventory\n" +
                             "[8] Display profit for all sold cars\n" +
                             "[9] Import/Export Data\n" +
                             "Enter a number from 0 to 9: "); // text block was a nice recommendation from ide
            System.out.println();

            input = s.nextInt();
            try {
                switch (input) {
                    case 1: // add a car
                        System.out.println("Enter an identifier for the car: ");
                        s.nextLine();
                        String id = s.nextLine();
                        System.out.println("Enter the miles on the odometer: ");
                        int miles = s.nextInt();
                        System.out.println("Enter the car's MPG: ");
                        int mpg = s.nextInt();
                        System.out.println("Enter the purchase price of the car: ");
                        double cost = s.nextDouble();
                        System.out.println("Enter the requested listing price: ");
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
                    case 9: // save data
                        System.out.print("Would you like to [0]export or [1]import data? ");
                        switch(s.nextInt()){
                            case 0:
                                lot.saveToDisk();
                                break;
                            case 1:
                                lot.loadFromDisk(s);
                                break;
                        }
                        break;
                }
            } catch (IllegalArgumentException e){
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) { // wasn't sure if there were any other messages I should add at this point
                System.err.println("Error: " + e);
            }

        }
    }
}*/
