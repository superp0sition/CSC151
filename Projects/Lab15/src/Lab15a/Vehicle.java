package Lab15a;

import java.util.ArrayList;

/**
 * Create an abstract class Vehicle.  A Vehicle has a single instance
 * variable of type String named "vehicleType" that describes the vehicle.
 * It has an abstract method getTires that takes no parameters and
 * returns an ArrayList<Tire> object that describes each Tire of the vehicle.
 *
 * A Tire class has been provided.  Vehicle has a single constructor that
 * takes the vehicle type as a parameter.
 * */

public abstract  Vehicle {
    private String vehicleType;

    public Vehicle(String type){
        vehicleType = type;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    abstract ArrayList<Tire> getTires();
}
