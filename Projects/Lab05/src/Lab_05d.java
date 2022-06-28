import java.util.Scanner;

public class Lab_05d {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int option;
        do{
            System.out.println( "[0] to Exit\n" +
                    "[1] Option 1\n" +
                    "[2] Option 2\n" +
                    "[3] Option 3\n" +
                    "[4] Option 4\n" +
                    "[5] Option 5");
            System.out.print("Enter a number from 0 to 5 : ");
            option = s.nextInt();
            if(option > 0 && option < 6)
                System.out.println("You selected option " + option);
            /*if(option != 0){
                if(option > 0 && option < 6){
                    System.out.println("You selected option " + option);
                }
                System.out.println("Press Any Key To Continue...");
                new Scanner(System.in).nextLine();
            }
        } while (option != 0);*/ // Wanted to check for all potential input that wouldn't throw an error but in the lab another loop condition is suggested, so I am keeping this code as a comment
        } while (option > 0 && option < 6);
    }
}