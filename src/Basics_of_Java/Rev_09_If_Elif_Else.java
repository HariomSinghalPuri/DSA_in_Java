package Basics_of_Java;

public class Rev_09_If_Elif_Else {

	public static void main(String[] args) {
		int age = 22;
		if (age <=4) {
		  System.out.println("You are Infant");
		}
		else if (age <= 18 ) {
		  System.out.println("You are Tenager");
		}
		else if (age <= 25) {
		System.out.println("You are Adult");
	    }
		else {
		  System.out.println("You are aged");
		}
		
		// Short Trick
		int time = 20;
		String result = (time < 18) ? "Good day." : "Good evening.";
		System.out.println(result);
	}

}
