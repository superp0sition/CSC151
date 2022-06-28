package Lab15a;

import java.util.ArrayList;

/**
 * Create a class Bicycle that extends Vehicle that has two Tires, both of type "skinny".
 * Bicycle should have a single default constructor.
 */

public class Bicycle extends Vehicle{
    public Bicycle(String type){
        super(type);
    }
    @Override
    ArrayList<Tire> getTires() {
        ArrayList<Tire> tires = new ArrayList<>();
        tires.add(new Tire("skinny"));
        tires.add(new Tire("skinny"));
        return tires;
    }
}
