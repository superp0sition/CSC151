package Lab14c;

import java.util.ArrayList;

/**
 * Start with the attached MyStack  Define a new stack class that extends ArrayList.
 * Write a test program that prompts the user to enter five strings and displays them in
 * reverse order.
 * */

public class MyStack extends ArrayList<Object>{

	public int getSize() {
		return size();
	}

	public Object peek() {
		return get(getSize() - 1);
	}

	public Object pop() {
		Object o = get(getSize() - 1);
		remove(getSize() - 1);
		return o;
	}

	public void push(Object o) {
		add(o);
	}

	@Override /** Override the toString in the Object class */
	public String toString() {
		return "stack: " + super.toString();
	}
}

