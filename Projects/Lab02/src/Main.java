import java.util.Scanner;

/* Test Case
Enter the pounds that Jack has: 4
Enter the shillings that Jack has: 10
Enter the pence that Jack has: 6
Enter the pounds for the pie: 1
Enter the shillings for the pie: 2
Enter the pence for the pie: 3
Enter the pounds for the beer: 1
Enter the shillings for the beer: 12
Enter the pence for the beer: 0

Jack's change is 1pounds 16shillings 3pence
*/

public class Main {
    public static void main(String[] args) {
	int pence = 0, shillings, pounds;
	Scanner s = new Scanner(System.in);

	System.out.print("Enter the pounds that Jack has: ");
	pence += 20 * 12 * s.nextInt();

	System.out.print("Enter the shillings that Jack has: ");
	pence += 12 * s.nextInt();

	System.out.print("Enter the pence that Jack has: ");
	pence += s.nextInt();

	//Pie section
	System.out.print("Enter the pounds for the pie ");
	pence -= 20 * 12 * s.nextInt();

	System.out.print("Enter the shillings for the pie: ");
	pence -= 12 * s.nextInt();

	System.out.print("Enter the pence for the pie: ");
	pence -= s.nextInt();

	//Beer section
	System.out.print("Enter the pounds for the beer: ");
	pence -= 20 * 12 * s.nextInt();

	System.out.print("Enter the shillings for the beer: ");
	pence -= 12 * s.nextInt();

	System.out.print("Enter the pence for the beer: ");
	pence -= s.nextInt();

	//Change output + calculation
	pounds = pence / (12 * 20);
	shillings = pence / 12 - pounds * 20;
	pence %= 12;
	System.out.printf("\nJack's change is %dpounds %dshillings %dpence", pounds, shillings, pence);
    }
}
