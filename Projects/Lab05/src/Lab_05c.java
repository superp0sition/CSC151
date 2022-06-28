import java.util.Scanner;

public class Lab_05c {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a number between 1 and 9 inclusive: ");
        int size = s.nextInt();
        boolean reverse = false; // boolean to check if the
        for(int i = 1; i - 1 >= 0; i += reverse ? -1 : 1){ // count up then down
            for(int j = size; j > i; j--){
                System.out.printf(" %s ",String.valueOf(j*j).replaceAll("[0-9]", " ")); // create spaces of the same length as square that would be here, probably some faster way of doing this
            }
            for(int k = i; k > 0; k--){
                System.out.printf(" %d ", k*k); // print numbers space separated, double spaces are used in both loops because that is what it seems is used in the screenshots
            }
            if(i == size)
                reverse = true; // make program count down once the size has been met
            System.out.println();
        }
    }
}
