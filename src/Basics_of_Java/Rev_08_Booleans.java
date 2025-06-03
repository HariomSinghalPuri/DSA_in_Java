package Basics_of_Java;

public class Rev_08_Booleans {

	public static void main(String[] args) {
		boolean isGodExists = true;
		boolean isMathsBoring = false;
		System.out.println(isGodExists);     // Outputs true
		System.out.println(isMathsBoring);   // Outputs false
		
		int x = 10;
		int y = 9;
		System.out.println(x > y); // returns true, because 10 is higher than 9
		
		int myAge = 12;
		int votingAge = 18;
		System.out.println(myAge >= votingAge); // returns false
	}

}
