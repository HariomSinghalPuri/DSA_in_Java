package Basics_of_Java;
import java.util.Scanner; 
public class Rev_03_User_Input {
	public static void main(String[] args) {
		Scanner S = new Scanner (System.in);
		System.out.print("Enter first number: "); 
		int num1 = S.nextInt(); 
		System.out.print("Enter second number: "); 
		int num2 = S.nextInt(); 
		int sum = num1 + num2; 
		System.out.println("The sum is: " +sum);
	}
}