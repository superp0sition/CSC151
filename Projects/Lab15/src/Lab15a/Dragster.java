package Lab15a;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create a class Dragster that extends Vehicle and has four Tires,
 * two of type "slick" and two of type "medium".  Dragster should
 * have a single default constructor.
 */

public class Dragster extends Vehicle {

    public Dragster(String type){
        super(type);
    }

    @Override
    ArrayList<Tire> getTires() {
        ArrayList<Tire> tires = new ArrayList<>();
        tires.add(new Tire("slick"));
        tires.add(new Tire("slick"));
        tires.add(new Tire("medium"));
        tires.add(new Tire("medium"));
        return tires;
    }
}
