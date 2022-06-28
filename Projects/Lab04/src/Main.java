import java.util.Scanner;

public class Main {
//You may use ONLY String's indexOf, charAt, length, compareTo, toUpperCase, toLowerCase, trim, equals, equalsIgnoreCase and substring methods
    public static void main(String[] args) {
        Scanner kybd = new Scanner(System.in);
        System.out.println("Enter a line of text");
        String aLine = kybd.nextLine();
        //If the user's input is shorter than 7 characters, print the message "The input is too short" and do no further processing.  If the user's input is 7 characters or longer, perform the following operations.
        if(aLine.length() < 7) {
            System.out.print("The input is too short");
            return;
        }

        //Print either "the original String has no leading or trailing whitespace" or "the original String has leading or trailing whitespace."  (Hint:  the trim method will be a good start, but you'll need more.)
        if(aLine.equals(aLine.trim()))
            System.out.println("The original String has no leading or trailing whitespace");
        else
            System.out.println("The original String has a leading or trailing whitespace");

        //Swap the first two and last five characters of aLine and print the result.
        System.out.println("\nFirst 2 and last 5 characters swapped:");
        System.out.println(aLine.substring(aLine.length()-5, aLine.length()) + aLine.substring(2, aLine.length()-5) + aLine.substring(0, 2));

        //Print aLine in all upper case.
        System.out.println("\nUpper case version of aLine:");
        System.out.println(aLine.toUpperCase());

        //If aLine has an odd number of characters, print "The line has an odd number of characters."  Otherwise, print the two middle characters of aLine.
        if(aLine.length() % 2 == 1)
            System.out.println("\nThe line has an odd number of characters.");
        else
            System.out.println("\nTwo middle characters: " + aLine.substring(aLine.length()/2 - 1, aLine.length()/2 + 1));

        //Print the compareTo results of comparing aLine in all lower case with the original aLine.  (This will be a number.)
        System.out.println("\ncompareTo lower case version:");
        System.out.println(aLine.compareTo(aLine.toLowerCase()));

        //Print whether the first half of aLine is the same as the last half of aLine except for case.
        System.out.println(aLine.substring(0, aLine.length()/2).equalsIgnoreCase(aLine.substring(aLine.length()/2, aLine.length())) ? "\nThe first half of aLine is the same as the second" : "\nThe first half of aLine is not the same as the second");

        //Print aLine with one character removed:  The first 'e' 'E' 's' or 'S'.
        System.out.println("\naLine with first e or s removed:");
        int indexOfLower = aLine.toLowerCase().indexOf('e'), indexOfLowerS = aLine.toLowerCase().indexOf('s');
        if(indexOfLower > indexOfLowerS && indexOfLowerS >= 0 )
            indexOfLower = aLine.toLowerCase().indexOf('s');
        else if(indexOfLower < 0)
            System.out.println("There is no s or e in aLine");
        else
            System.out.println(aLine.substring(0, indexOfLower) + aLine.substring(indexOfLower + 1, aLine.length()));
    }
}
