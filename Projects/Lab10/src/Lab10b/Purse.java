package Lab10b;

public class Purse {
    //three int instance variables: pounds, shillings and pence.
    private int pounds;
    private int shillings;
    private int pence;

    //a no argument constructor (i.e., Purse()) that initializes the instance variables to 0.
    public Purse(){
        pounds = 0; shillings = 0; pence = 0;
    }

    //a mutator  method void addPounds(int poundsToAdd)
    public void addPounds(int pounds) {
        this.pounds += pounds; // add a number of pounds
    }

    //a mutator  method void addShillings(int shillingsToAdd)  You may assume shillingsToAdd is less than 20.  Note that if addShillings increases the number of shillings to 20 or more, the pounds value should be increased until shillings is less than 20.
    public void addShillings(int shillings){
        this.addPounds(shillings / 20); // integer division to upcast values
        this.shillings += shillings % 20;
    }

    //a mutator  method void addPence(int penceToAdd)  You may assume penceToAdd is less than 12.  Note that if addPence increases the number of pence to 12 or more, the shillings value should be increased until pence is less than 12.
    public void addPence(int pence) {
        this.addShillings(pence / 12); // same idea as shillings
        this.pence += pence % 12;
    }

    //an accessor method int getPounds() that returns the number of pounds in the purse
    public int getPounds() {
        return pounds;
    }

    //an  accessor  method int getShillings() that returns the number of shillings (<20) in the purse.
    public int getShillings() {
        return shillings;
    }

    //an  accessor  method int getPence() that returns the number of pence (<12) in the purse.
    public int getPence() {
        return pence;
    }

    //a mutator method void spend(int poundsToRemove, int shillingsToRemove, int penceToRemove) that removes the specified amount of money from the purse.  You may assume the purse has sufficient total funds to cover the withdrawal, though you may have to break a pound into shillings, or a shilling into pence.
    public void spend(int poundsToRemove, int shillingsToRemove, int penceToRemove){
        addPence(-((poundsToRemove*20+ shillingsToRemove)*12 + penceToRemove)); // add a negative amount since any amount is upcasted
    }

    //an accessor method String toString() that returns a String representation of the purse (such as "pounds 3, shillings 10, pence 5")
    public String toString(){
        return String.format("pounds %d, shillings %d, pence %d", pounds, shillings, pence);
    }
}
