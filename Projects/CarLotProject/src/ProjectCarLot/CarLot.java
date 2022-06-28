package ProjectCarLot;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CarLot extends ArrayList<Car>{
    /*
     * CONSTRUCTORS
     */

    public CarLot(){
        super();
    }

    /*
     * ACCESSORS
     */

    // Car findCarByIdentifier(String identifier).  Find the car with the specified identifer in the inventory. Return null if the Car is not found
    public Car findCarByIdentifier(String identifier){
        int index = -1;
        for (Car car : this)
            if (car.getId().equals(identifier)) {
                return car;
            }
        return null;
    }

    // ArrayList<Car> getCarsInOrderOfEntry(). Return an ArrayList of all Cars in the inventory, ordered by their entry into the inventory. This method should return a copy of the inventory, not the inventory itself
    public ArrayList<Car> getCarsInOrderOfEntry(){
        return (ArrayList<Car>) this.clone();
    }

    // ArrayList<Car> getCardsSortedByMPG(). Return an ArrayList of all Cars in the inventory, sorted by MPG. This method should not sort the inventory, but should instead make a copy of the inventory and sort the copy
    public ArrayList<Car> getCardsSortedByMPG(){
        ArrayList<Car> temp = getCarsInOrderOfEntry();
        temp.sort(Comparator.comparing(Car::getMpg));
        return temp;
    }

    // Car getCarWithBestMPG(). Return the Car in the inventory with the highest MPG
    public Car getCarWithBestMPG(){
        int maxIndex = 0;
        for(int i = 0; i < size(); i++)
            if(get(maxIndex).getMpg() < get(i).getMpg())
                maxIndex = i;
        return get(maxIndex);
    }

    // Car getCarWithHighestMileage(). Return the Car in the inventory with the highest mileage
    public Car getCarWithHighestMileage(){
        int maxIndex = 0;
        for(int i = 0; i < size(); i++)
            if(get(maxIndex).getMileage() < get(i).getMileage())
                maxIndex = i;
        return get(maxIndex);
    }

    // double getAverageMpg(). Return the average MPG of all Cars in the inventory
    public double getAverageMpg(){
        int sum = 0;
        for(Car c : this)
            sum += c.getMpg();
        return (double)sum / size();
    }

    // double getTotalProfit(). Return the total profit of all cars in the inventory that have been sold
    public double getTotalProfit(){
        double total = 0;
        for(Car c : this)
            total += c.getProfit();
        return total;
    }

    public void saveToDisk(File file) throws IOException { // Enhancement: Now is passed a file instead of using hardcoded one
        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        for(Car c : this){
            writer.write(String.format("%s,%d,%f,%f,%f,%b,%f\n", c.getId(), c.getMileage(), c.getMpg(), c.getCost(), c.getSalesPrice(), c.isSold(), c.getPriceSold()));
        }
        writer.flush();
        writer.close();
    }

    /*
     * MUTATORS
     */

    // void addCar(String id, int mileage, int mpg, double cost, double salesPrice).  Add a new Car with the specified id, mileage, mpg, cost, and salesPrice to the inventory
    public void addCar(String id, int mileage, double mpg, double cost, double salesPrice){
        add(new Car(id, mileage, mpg, cost, salesPrice));
    }

    // void sellCar(String identifier, double priceSold ) throws IllegalArgumentException. Sell the Car identified by identifier for the priceSold. If the Car does not exist in the identifier, throw an IllegalArgument Exception with an appropriate error message
    public void sellCar(String identifier, double priceSold ) throws IllegalArgumentException {
        Car c = findCarByIdentifier(identifier);
        if (c == null)
            throw new IllegalArgumentException("You cannot sell a car that is not in your inventory!"); // forgot to add this last week, remembered for this one
        else
            c.sellCar(priceSold);
    }

    public void loadFromDisk(File filename) { // Enhancement: like saveToDisk, now uses passed file rather than hardcoded name
        int i = 1;
        this.clear();
        try(Scanner s = new Scanner(new FileReader(filename))) {
            String line = "";
            Object[] data;
            while(s.hasNextLine()){
                line = s.nextLine();
                data = line.split("[,]");
                try{
                add(new Car(                data[0].toString(),
                        Integer.parseInt(   data[1].toString()),
                        Double.parseDouble( data[2].toString()),
                        Double.parseDouble( data[3].toString()),
                        Double.parseDouble( data[4].toString()),
                        Boolean.parseBoolean(data[5].toString()),
                        Double.parseDouble( data[6].toString())));
                } catch (Exception e) {
                    throw new NumberFormatException("Malformed data");
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
