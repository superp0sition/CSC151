package ProjectCarLot;

public class Car {
    /*
     * INSTANCE VARIABLES
     */

    private String id = "N/A";
    private int mileage = 0;
    private double mpg = 0;
    private double cost = 0;
    private double salesPrice = 0;
    private double priceSold = 0;
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
        cost = priceCost;
        salesPrice = priceSell;
    }

    public Car(String id, int mileage, double mpg, double priceCost, double priceSell, boolean isSold, double priceSold){
        this.id = id;
        this.mileage = mileage;
        this.mpg = mpg;
        cost = priceCost;
        salesPrice = priceSell;
        this.isSold = isSold;
        this.priceSold = priceSold;
        if(isSold)
            sellCar(priceSold);
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

    public double getCost() { return cost; }

    public double getSalesPrice() { return salesPrice; }

    public double getPriceSold() {
        return priceSold;
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
    public int comparePrice(Car otherCar) { return Double.compare(this.salesPrice, otherCar.getSalesPrice()); }

    /**
     * @return string containing instance variables of the car
     */
    @Override
    public String toString() {
        String ret = String.format("Car: %s, Mileage:  %d, MPG %f, Sold:  %s, Cost: $%.2f, Selling price: $%.2f", id, mileage, mpg,isSold ? "Yes" : "No", cost, priceSold);
        if(isSold)
            ret += String.format(", Sold For $%.2f, Profit: $%.2f", getPriceSold(), getProfit());
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
        this.cost = cost;
    }

    public void setSalesPrice(double salesPrice) { this.salesPrice = salesPrice; }

    public void setPriceSold(double priceSold) {
        this.priceSold = priceSold;
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
        setProfit(priceSold - cost);
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}

