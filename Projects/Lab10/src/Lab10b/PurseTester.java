package Lab10b;

import java.util.Scanner;

// Given code
public class PurseTester {
    public static void main(String[] args) {
        Scanner kybd = new Scanner(System.in);
        Purse sophie = new Purse();
        Purse sally = new Purse();

        System.out.print("Enter 1 for Sophie, 2 for Sally, or 0 to exit: ");
        int operation = kybd.nextInt();
        while (operation != 0) {
            Purse currentPurse;  // alias greatly simplifies things later
            if (operation == 1) {
                currentPurse = sophie;
            } else if (operation == 2) {
                currentPurse = sally;
            } else {
                currentPurse = null;  // will eventually give null ptr on invalid input
            }

            System.out.print("Enter 1 to give pence, 2 to give shillings, "
                    + "3 to query her purse: ");
            int giveOrQuery = kybd.nextInt();
            if (giveOrQuery == 1) {
                System.out.print("Enter the pence to give: ");
                int amt = kybd.nextInt();
				currentPurse.addPence(amt);
            } else if (giveOrQuery == 2) {
                System.out.print("Enter the shillings to give: ");
                int amt = kybd.nextInt();
				currentPurse.addShillings(amt);
            } else if (giveOrQuery == 3) {
                System.out.println(currentPurse);
            }

            System.out.print("Enter 1 for Sophie, 2 for Sally, or 0 to exit: ");
            operation = kybd.nextInt();
        }
        kybd.close();
    }
}
