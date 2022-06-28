
import java.util.Map;
import java.util.TreeMap;

public class CountingSort<T> {
    private final T[] output; // Not sure why IntelliJ wanted these to be final
    private final Map<T, MutableInt> counts = new TreeMap<>(); // Create counts as a sorted dictionary

    // Tried my best to make my own code for this class, but this implementation was pretty much perfect, and there is a good chance I would have ended up with this without seeing it.
    // I removed the merge method since it was giving me problems initially, and had to debug a bit for this.
    // Comments throughout the code are more to demonstrate my understanding due to having seen the solution.
    // https://stackoverflow.com/questions/33666488/how-to-make-generic-counting-sort-method

    // I don't really understand how I would convert this code to work with primitive types

    public CountingSort(T[] a){
        output = a; // define output as the original array

        for(T i : a){
            MutableInt count = counts.get(i); // Get the mutableint for the current key
            if (count == null)
                counts.put(i, new MutableInt()); // Add the key if it does not exist
            else
                count.increment(); // Increment otherwise
        }
    }

    //Both functions below are the same, but making two functions is much faster than reversing the array

    public void SortAscending(){
        int iterator = 0; // create array iterator
        for(Map.Entry<T, MutableInt> i : counts.entrySet()) // forEach over all 'counts' entries
            for (int j = 0; j < i.getValue().get(); j++) // repeat for however many times the value appears
                output[iterator++] = i.getKey(); // place key j times into original array
    }

    public void SortDescending(){
        int iterator = output.length - 1;
        for(Map.Entry<T, MutableInt> i : counts.entrySet())
            for (int j = 0; j < i.getValue().get(); j++)
                output[iterator--] = i.getKey();
    }

    public T[] getOutput() { // get function for class
        return output;
    }
}

// I found this looking for ways to iterate over the map, originally was using putIfAbsent and replace, since I didn't
// exactly understand how to use merge correctly
// https://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
class MutableInt {
    int value = 1; // note that we start at 1 since we're counting
    public void increment () { ++value;      }
    public int  get ()       { return value; }
}