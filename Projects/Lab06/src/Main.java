import java.util.Scanner;

public class Main {

    /** Return true if the card number is valid */
    public static boolean isValid(long number){
        /* // Convert long to string and check chars
        String card = Long.toString(number); // kept this because this method could just as easily be used
        return (card.charAt(0) == '4' || card.charAt(0) == '5' || card.charAt(0) == '6' || card.substring(0, 2).equals("37")) && (card.length() <= 16 && card.length() > 13);*/
        int size = getSize(number);
        if (!((prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 6) || prefixMatched(number, 37)) && (size <= 16 && size >= 13))) // long if not checking all valid prefixes and length
            return false;
        int sumEven = sumOfDoubleEvenPlace(number), sumOdd = sumOfOddPlace(number); // trying to use slightly better practice, could have had in return
        return (sumEven + sumOdd) % 10 == 0;
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number){
        String card = Long.toString(number);
        int sum = 0;
        for(int i = 0; i < card.length(); i += 2){
            sum += getDigit((card.charAt(i) - '0') * 2); // Could also use Character.getNumericValue()
        }
        return sum;
    }

    /**
     * Return this number if it is a single digit, otherwise, return the sum of the
     * two digits
     */
    public static int getDigit(int number){
        if (number >= 10)
            return (number / 10) + (number % 10); // number is always < 20 so I don't need to check it
        return number;
    }

    /** Return sum of odd place digits in number */
    public static int sumOfOddPlace(long number){
        String card = Long.toString(number);
        int sum = 0;
        for(int i = 1; i < card.length(); i += 2){ // start at 1st index instead of 0 for odds
            sum += getDigit(card.charAt(i) - '0');
        }
        return sum;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d){
        return (getPrefix(number, getSize(d)) == d); // compares the prefix to long casted d
    }

    /** Return the number of digits in d */
    public static int getSize(long d){
        return (int)(Math.log10(d) + 1); // return how many multiples of 10 fit into the number
    }

    /**
     * Return the first k number of digits from number. If the number of digits in
     * number is less than k, return number.
     */
    public static long getPrefix(long number, int k){
        int size = getSize(number);
        if(size < k)
            return number;
        return (number / (long)Math.pow(10, size - k)); // divide by how large the number is minus the number of numbers at the start you would like
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a credit card number: ");
        long card = s.nextLong();
        System.out.printf("This credit card %s valid", isValid(card) ? "is" : "is not");
    }
}
