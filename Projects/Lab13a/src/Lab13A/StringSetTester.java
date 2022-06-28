package Lab13A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StringSetTester {

    public static void SanityCheck() {
        StringSet objStrSet0 = new StringSet();

        // have to wait for inheritance lab for this to compile.
        ArrayList<String> ss2 = new StringSet();

        ss2.add("");
        int int0 = objStrSet0.size();
        int0 = objStrSet0.numChars();
        int0 = objStrSet0.countStrings("xyzzy");
        int0 = objStrSet0.sumValidIntegers();
        objStrSet0.pop();
    }

    public static void main(String[] args) {
        if(Arrays.asList(args).contains("-check")){
            SanityCheck();
            return;
        }

        Scanner s = new Scanner(System.in);

        System.out.print("How many strings would you like to input? ");
        int amt = s.nextInt();
        var strings = new StringSet();
        s.nextLine();

        for (int i = 0; i < amt; i++)
            strings.add(s.nextLine());

        System.out.printf("You added %d strings.\n", strings.size());
        System.out.printf("They contained %d chars\n", strings.numChars());
        System.out.printf("The sum of all valid integer strings is: %d\n", strings.sumValidIntegers());

        System.out.print("\nEnter a string to look for: ");
        System.out.printf("%d instance(s) were found", strings.countStrings(s.next()));

        s.close();
    }
}
