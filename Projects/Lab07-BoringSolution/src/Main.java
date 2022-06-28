import java.util.Arrays;
import java.util.Random;

// The purpose of this class is to complete this lab in a way closer to the chapter material compared to my other solution

public class Main {
    // The following method takes the original array, and
    // uses Arrays.sort to create a new, sorted array.
    // original is not modified in any way.
    public static double[] loToHi(double[] original){
        Arrays.sort(original); // use the sort method from Arrays
        return original; // return sorted array
    }

    // The following method takes the original array, and
    // returns a new array sorted starting with the highest number.
    // The original array is not modified in any way.
    // Hint: you can call loToHi to make life easier in this method.
    public static double[] hiToLo(double[] original){
        double[] sorted = loToHi(original); // sort array then reverse it
        double temp = 0;
        for(int i = 0; i < original.length / 2; i++){ // switches end values with each iteration
            temp = sorted[i]; // store sorted value in temp
            sorted[i] = sorted[original.length - 1 - i]; // swap values
            sorted[original.length - 1 - i] = temp; // replace end value
        }
        return sorted; // return this sorted array
    }

    // The following method returns the average of the given array
    public static double avg(double[] original){
        // I retried this avg method here first because I thought dividing last might work, it doesn't

        /*double avg = 0;
        for(Double i : original){ // add each value to total
            avg += i;
        }
        return avg / original.length;*/ // divide by size
        return Arrays.stream(original).average().orElse(0);
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
        double[] arr = random.doubles(1000000,0,1).toArray();
        double average = avg(arr);
        double averageLoToHi = avg(loToHi(arr));
        double averageHiToLo = avg(hiToLo(arr));

        System.out.printf("%f\n%f\n%f\n%s",average,averageLoToHi,averageHiToLo, (average == averageLoToHi && average == averageHiToLo) ? "The averages are identical" : "The averages are different");
    //time taken to code ~10 minutes including reading documentation
    }
}
