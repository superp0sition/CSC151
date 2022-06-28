import java.util.Scanner;

public class Main {

    public static boolean response(Scanner s){
        String currentQ = s.next().toUpperCase(); // reinitialize each time, don't know if this is inefficient
        while (!currentQ.equals("Y")  && !currentQ.equals("N")) { // make sure expected chars are given
            System.out.println("Please input a character Y/n");
            currentQ = s.next().toUpperCase();
        }
        return currentQ.equals("Y"); // test if true, false if not
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Are Your Parents Visiting? ");
        boolean parents = response(s);

        System.out.print("Is the weather good? ");
        boolean weather = response(s);

        System.out.print("Are you rich? ");
        boolean rich = response(s);

        /*
        * If my parents are visiting and the weather's bad, we'll stay in.
        * If they're visiting and the weather's good, we'll go to the cinema.
        * If they're not visiting and I'm poor, I'll stay in.
        * If they're not visiting and the weather is good and I'm rich, I'll go shopping.
        * Otherwise, I'll go to the cinema.
        * */

        if (parents) {
            if (weather)
                System.out.print("Go to the cinema.");
            else
                System.out.print("Stay in.");
        }
        else{
            if(!rich)
                System.out.print("Go Shopping.");
            else if(rich && weather)
                System.out.print("Stay in.");
            else
                System.out.print("Go to the cinema.");
        }
    }
}
