package Basics_of_Java;
import java.util.*;
// We Are Addition two using using return Statements.
public class Rev_17_Return_Values {
	public static void main(String[] args) {
		//  Now we are calling each parameter one by one
		greet();
		int first = readNumber();
		int second = readNumber();
		int sum = first + second;
		System.out.println("Sum of the numbers is: " + sum);
	}
	public static int readNumber() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the number: ");
		int number = input.nextInt();
		return number;
	}
	public static void greet() {
		System.out.println("Welcome to Calculator\n");
	}
}