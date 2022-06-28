package CarLotProject;

public class Car {
    /*
     * INSTANCE VARIABLES
     */

    private String id = "N/A";
    private int mileage = 0;
    private double mpg = 0;
    private double Cost = 0;
    private double SalesPrice = 0;
    private double PriceSold = 0;
    private boolean isSold = false;
    private double profit = 0;

    /*
     * CONSTRUCTORS
     */

    public Car(){}

    public Car(String id){
        this.id = id;
    }

    public Car(String id, int mileage, double mpg, double priceCost, double priceSell){
        this.id = id;
        this.mileage = mileage;
        this.mpg = mpg;
        this.Cost = priceCost;
        this.SalesPrice = priceSell;
        this.isSold = false;
    }

    /*
     * ACCESSORS
     */

    public String getId() { return id; }

    public int getMileage(){
        return mileage;
    }

    public double getMpg() {
        return mpg;
    }

    public double getCost() {
        return Cost;
    }

    public double getSalesPrice() { return SalesPrice; }

    public double getPriceSold() {
        return PriceSold;
    }

    public boolean isSold() {
        return isSold;
    }

    /**
     * @return returns the value price - profit if the car is sold, and 0 for unsold cars
     */
    public double getProfit (){
        return profit;
    }

    /**
     * @param otherCar car to compare to
     *
     * @return returns a number greater than 0 if this car's mpg is greater, a number less than 0 if otherCar's is greater, and 0 if they are the same
     */
    public int compareMPG(Car otherCar){
        return Double.compare(this.mpg, otherCar.getMpg());
    }

    /**
     * @param otherCar car to compare to
     * @return returns a number greater than 0 if this car's miles are greater, a number less than 0 if otherCar's are greater, and 0 if they are the same
     */
    public int compareMiles(Car otherCar){
        return Integer.compare(this.mileage, otherCar.getMileage());
    }

    /**
     * @param otherCar car to compare to
     * @return returns a number greater than 0 if this car's price is greater, a number less than 0 if otherCar's is greater, and 0 if they are the same
     */
    public int comparePrice(Car otherCar) { return Double.compare(this.SalesPrice, otherCar.getSalesPrice()); }

    /**
     * @return string containing instance variables of the car
     */
    @Override
    public String toString() {
        String ret = "Car: %s, Mileage:  %d, MPG %f, Sold:  %s, Cost: $%.2f, Selling price: $%.2f".formatted(id, mileage, mpg,isSold ? "Yes" : "No", Cost, PriceSold);
        if(isSold)
            ret += ", Sold For $%.2f, Profit: $%.2f".formatted(getPriceSold(), getProfit());
        return ret;
    }


    /*
     * MUTATORS
     */

    public void setId(String id) {
        this.id = id;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public void setCost(double cost) {
        this.Cost = cost;
    }

    public void setSalesPrice(double salesPrice) { this.SalesPrice = salesPrice; }

    public void setPriceSold(double priceSold) {
        this.PriceSold = priceSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public void addMiles(int milesToAdd){
        this.mileage += milesToAdd;
    }

    public void sellCar(double priceSold){
        setSold(true);
        this.setPriceSold(priceSold);
        setProfit(isSold ? PriceSold - Cost : 0);
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
