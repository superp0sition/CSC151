import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.*;

public class Main{

    public static void main (String[] args) {
        try{
            System.out.println("nfe");
            return;
        } finally {
            System.out.println("help");
        }

    }
}

class A{
    int i = 7;

    public A(){
        setI(20);
        System.out.println("i from A is " + i);
    }

    public void setI(int i){
        this.i = 2 * i;
    }
}

class B extends A {
    public B(){
        System.out.println("i from B is " + i);
        }

    @Override
    public void setI(int i) {
        this.i = 3 * i;
    }
}

/*public class Main {
        public static void main(String[] args) throws Exception {
            File file = new File(args[0]);
            String s = Integer.toString()
            try {
                Scanner s = new Scanner(file);
                long charCount = 0L;
                int lines = 0;
                int words = 0;

                while (s.hasNext()) {
                    String line = s.nextLine();

                    String[] wordArray = line.split(" ");

                    charCount += line.length();
                    lines += 1;
                    words += wordArray.length;
                }
                System.out.printf("File %s has\n%d characters\n%d words\n%d lines%n%n",
                        args[0], charCount, words, lines);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}*/

/*public class Main {
    // Compute the deviation of double values

    public static double deviation(double[] x){
        double sum = 0;
        double mean = mean(x);
        for(double i : x){
            sum += Math.pow(i - mean, 2);
        }
        return Math.sqrt(sum/(x.length-1));
    }

    // Compute the mean of an array of double values

    public static double mean(double[] x){
        double total = 0;
        for(double i : x){
            total += i;
        }
        return total / x.length;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] arr = new double[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = input.nextDouble();
        }
        System.out.printf("The mean is %.2f\n" +
        "The standard deviation is %.5f", mean(arr), deviation(arr));
    }
}*/

/*import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int val = input.nextInt();
        if(val == 0)
            return;
        Map<Integer, Integer> counts = new TreeMap<>();

        while(val != 0){
            counts.putIfAbsent(val, 0);
            counts.replace(val, counts.get(val) + 1);
            val = input.nextInt();
        }
        for(var i : counts.entrySet()){
            System.out.printf("%d occurs %d %s\n", i.getKey(), i.getValue(), i.getValue() == 1 ? "time" : "times");
        }
    }
}*/

/*

import java.util.Scanner;
public class Main {
    public static void m(int i) {
        double result = 0;
        System.out.println("i m(i)");
        for (int j = 1; j <= i; j++) {
            result += (double)j / (j + 1);
            System.out.printf("%d %.4f\n",j, result);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        m(input.nextInt());
    }
}
/*
for(i = 1; i <= n; i++){
    for(j = 1; j <= i; j++)
        System.out.print("*");
    System.out.print("\n");
}
*/