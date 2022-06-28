package Lab13A;

import java.util.*;

/**
 * Child of the {@code ArrayList} class of type {@code String}
 *
 * @author  David Badcoe
 * @see     ArrayList
 */
public class StringSet extends ArrayList<String> {

    public StringSet() {
        super();
    }

    /**
     * Removes the last element of the StringSet
     *
     * @throws NoSuchElementException {@inheritDoc}
     */
    public void pop(){
        try {
            remove(size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException("You cannot remove an element from an empty StringSet!");
        }
    }

    /**
     * Checks each element of the ArrayList to see if it contains
     * a number, and sums them if so.
     *
     * @return the sum of all valid number strings
     */
    public int sumValidIntegers(){
        int sum = 0;
        for(String s : this)
            if(s.matches("^[0-9]\\d*$"))
                sum += Integer.parseInt(s);
        return sum;
    }

    /**
     * Sums the string lengths of each element of the StringSet
     *
     * @return the sum of the length of all strings
     */
    public int numChars(){
        int chars = 0;
        for(String s : this)
            chars += s.length();
        return chars;
    }

    /**
     * Checks every string in this StringSet for {@code stringToLookFor} and
     * returns the number that contain this string
     *
     * @param stringToLookFor The string to be searched in the StringSet
     *
     * @return the number of strings that contain at least one
     * instance of {@code stringToLookFor}
     */
    public int countStrings(String stringToLookFor){
        int count = 0;
        for (String s : this)
            if(s.contains(stringToLookFor))
                count++;
        return count;
    }
}