package Lab14c;

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 5 strings: ");
		MyStack stack = new MyStack();

		for (int i = 0; i < 5; i++)
			stack.push(input.nextLine());
		System.out.println(stack.getSize() + " strings are: ");
		while (!stack.isEmpty())
			System.out.println(stack.pop());

		input.close();
	}
}
