import java.util.Arrays;
import java.util.Random;

public class Main {
    // The following method takes the original array, and
    // uses Arrays.sort to create a new, sorted array.
    // original is not modified in any way.
    public static Double[] loToHi(Double[] original){
        CountingSort<Double> sorted = new CountingSort<>(original);
        sorted.SortAscending();
        return sorted.getOutput();
    }

    // The following method takes the original array, and
    // returns a new array sorted starting with the highest number.
    // The original array is not modified in any way.
    // Hint: you can call loToHi to make life easier in this method.
    public static Double[] hiToLo(Double[] original){
        CountingSort<Double> sorted = new CountingSort<>(original);
        sorted.SortDescending();
        return sorted.getOutput();
    }

    // The following method returns the average of the given array
    public static Double avg(Double[] original){
    /*    double avg = ;
        for(Double i : original){
            avg += i;
        }
        return avg / original.length;
    */ // original method does not work for lab size, had to change
        return Arrays.stream(original).mapToDouble(a -> a).average().orElse(0);
    }

    // The main method
    // 1: will create a double[] containing one million (1,000,000)
    // elements.
    // 2: It will assign a random number between 0 and 1 to each element.
    // 3: It will use the avg method to calculate the average of the array. Call this value averageRandom.
    // 4: It will use loToHi to create a new sorted array of the same values,
    // and calculate its average using avg. Call this value averageLoToHi.
    // 5: It will use hiToLo to create a new array sorted from the highest
    // value to the smallest, and calculate its average using avg. Call this value averageHiToLo.
    // 6: It will print the three averages, one per line.
    // 7: It will print whether the 3 averages are identical or not.
    public static void main(String[] args){
        Random random = new Random();

        double[] temp = random.doubles(1000000,0,1).toArray();
        Double[] arr = Arrays.stream(temp).boxed().toArray(Double[]::new);

        double average = avg(arr);
        double averageLoToHi = avg(loToHi(arr));
        double averageHiToLo = avg(hiToLo(arr));

        System.out.printf("%f\n%f\n%f\n%s",average,averageLoToHi,averageHiToLo, (average == averageLoToHi && average == averageHiToLo) ? "The averages are identical" : "The averages are different");
    }
}
