package Lab14b;

import java.util.ArrayList;

/**
 * Start with the attached Course Class. Use an ArrayList to replace an array to store students.
 * One of the goals of the chapter is to use ArrayLists instead of arrays.
 *
 * You should not change the original contract of the Course class (i.e., the definition of the
 * constructors and methods should not be changed, but the private members may be changed.)
 * When it states do not change the contract of the course class it means that you can change in
 * internal workings of Course but to the testers and outside world it needs to behave the same.
 * */

public class Course extends ArrayList<String> {
	private final String courseName;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public void addStudent(String student) {
		add(student);
	}

	public String[] getStudents() {
		return this.toArray(String[]::new);
	}

	public int getNumberOfStudents() {
		return size();
	}

	public String getCourseName() {
		return courseName;
	}

	public void dropStudent(String student) {
		remove(student);
	}
}
