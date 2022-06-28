package Lab12a;

import java.util.Scanner;

public class StringSetTester {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("How many strings would you like to input? ");
        int amt = s.nextInt();
        StringSet strings = new StringSet();
        s.nextLine(); // was forgetting to clear the stringbuffer so I kept getting an extra 0 byte string
        // double dumb, just read this in the hint part of the prompt
        for(int i = 0; i < amt; i++)
            strings.add(s.nextLine());

        System.out.printf("You added %d strings.\n", strings.size());
        System.out.printf("They contained %d chars\n", strings.numChars());
        System.out.printf("The sum of all valid integer strings is: %d\n", strings.sumValidIntegers());

        System.out.print("\nEnter a string to look for: ");
        System.out.printf("%d instance(s) were found",strings.countStrings(s.next()));

    }
}
