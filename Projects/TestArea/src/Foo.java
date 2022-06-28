import java.util.Scanner;

public class Foo {
    static int i = 0;
    static int j = 0;
    public static void main (String[] args){
        int i = 2;
        int k = 3;
        {
            int j = 3;
            System.out.println("i+j " +i+j);
        }
        k=i+j;
        System.out.println(k);
        System.out.println(j);
    }

    static void p(){
        String s = "5.6";
        Integer.parseInt(s);

        int i = 0;
        int y = 2/i;
        System.out.println("W");
    }
}
