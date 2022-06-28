package CarLotProject;

import java.util.ArrayList;
import java.util.Comparator;

public class CarLot {
    /*
     * INSTANCE VARIABLES
     */

    private ArrayList<Car> inventory = new ArrayList<>();

    /*
     * CONSTRUCTORS
     */

        public CarLot(){}

    /*
     * ACCESSORS
     */

    // Car findCarByIdentifier(String identifier).  Find the car with the specified identifer in the inventory. Return null if the Car is not found
    public Car findCarByIdentifier(String identifier){
        int index = -1;
        for (Car car : inventory)
            if (car.getId().equals(identifier)) {
                return car;
            }
        return null;
    }

    // ArrayList<Car> getCarsInOrderOfEntry(). Return an ArrayList of all Cars in the inventory, ordered by their entry into the inventory. This method should return a copy of the inventory, not the inventory itself
    public ArrayList<Car> getCarsInOrderOfEntry(){
        return (ArrayList<Car>) inventory.clone();
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
        for(int i = 0; i < inventory.size(); i++)
            if(inventory.get(maxIndex).getMpg() < inventory.get(i).getMpg())
                maxIndex = i;
        return inventory.get(maxIndex);
    }

    // Car getCarWithHighestMileage(). Return the Car in the inventory with the highest mileage
    public Car getCarWithHighestMileage(){
        int maxIndex = 0;
        for(int i = 0; i < inventory.size(); i++)
            if(inventory.get(maxIndex).getMileage() < inventory.get(i).getMileage())
                maxIndex = i;
        return inventory.get(maxIndex);
    }

    // double getAverageMpg(). Return the average MPG of all Cars in the inventory
    public double getAverageMpg(){
        int sum = 0;
        for(Car c : inventory)
            sum += c.getMpg();
        return (double)sum / inventory.size();
    }

    // double getTotalProfit(). Return the total profit of all cars in the inventory that have been sold
    public double getTotalProfit(){
        double total = 0;
        for(Car c : inventory)
            total += c.getProfit();
        return total;
    }

    /*
     * MUTATORS
     */

    // void addCar(String id, int mileage, int mpg, double cost, double salesPrice).  Add a new Car with the specified id, mileage, mpg, cost, and salesPrice to the inventory
    public void addCar(String id, int mileage, int mpg, double cost, double salesPrice){
        inventory.add(new Car(id, mileage, mpg, cost, salesPrice));
    }

    // void sellCar(String identifier, double priceSold ) throws IllegalArgumentException. Sell the Car identified by identirier for the priceSold. If the Car does not exist in the identifier, throw an IllegalArgument Exception with an appropriate error message
    public void sellCar(String identifier, double priceSold ){
        findCarByIdentifier(identifier).sellCar(priceSold);
    }
}
