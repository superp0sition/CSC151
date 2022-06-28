package Lab12a;

import java.util.Arrays;

public class StringSet {
    // an instance variable of type String[]
    private String[] set = new String[0];
    // an int instance variable that indicates the number of String objects that the StringSet currently contains
    private int strings = 0;

    // a single no-argument constructor
    public StringSet(){}

    // a mutator that adds a String newStr to the StringSet object.  If adding the new String to the String[] succeeds, the add method returns true.
    // If adding the new String to the String[] fails (maybe the array is already full, for example), add returns false.
    public boolean add(String newStr){
        if (strings == Integer.MAX_VALUE - 5)
            return false;
        /*if (strings == 0 && 1 == set.length) {
            set[0] = newStr;
            strings++;
            return true;
        }*/
        set = Arrays.copyOf(set, set.length+1); // reallocate array size each time an element is added so it can be potentially any size up to Int max - 5
        set[strings++] = newStr;
        return true;
    }

    // a mutator that removes the most-recently added String from the StringSet.  If the StringSet is empty, the method does nothing.
    // for example, if a StringSet contains
    // "abc"
    // "def"
    // "ghi"
    // calling pop results in the StringSet containing two Strings, "abc" and "def"
    public void pop(){
        set = Arrays.copyOf(set, set.length-1); // copy array but change length to be one less, should truncate array
    }


    // an accessor that returns the number of String objects that have been added to this StringSet object
    public int size(){
        return set.length;
    }
    // an accessor that returns the sum of the number of elements that are valid integers
    // For example, if the StringSet contains
    // "123"
    // "TEST"
    // "7"
    // Then calling sumValidIntegers() would return 130. The method should never throw an
    // exception if the data is not a valid integer.
    public int sumValidIntegers(){
        int sum = 0;
        for (String s: set) {
            if(s.matches("^[0-9]\\d*$"))
                sum += Integer.parseInt(s);
        }
        return sum;
    }
    // an accessor that returns the total number of characters in all of the Strings that have been added to this StringSet object
    public int numChars(){
        int chars = 0;
        for (String s : set) {
            chars += s.length();
        }
        return chars;
    }

    // an accessor that returns the number of Strings in the StringSet object that contain a given substring
    public int countStrings(String stringToLookFor){
        int number = 0;
        for (String s : set) {
            if(s.contains(stringToLookFor))
                number++;
        }
        return number;
    }
}

