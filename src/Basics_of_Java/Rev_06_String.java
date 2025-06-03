package Basics_of_Java;

public class Rev_06_String {

	public static void main(String[] args) {
		String greeting = "Hello,My Name Is Hariom Singhal Puri";
		System.out.println(greeting);                      //This will Print Our String.
		System.out.println(greeting.length());             //This Will print What is the Length of our String.
		System.out.println(greeting.toUpperCase());        //This will Convert all Words in UpperCase.
		System.out.println(greeting.toLowerCase());        //This will Convert all words in LowerCase.
		System.out.println(greeting.indexOf("Name"));      //This will Give us Index of the the words where it is Started.
		
		String firstName = "Hariom ";
		String lastName = "Puri";
		System.out.println(firstName.concat(lastName)); // This is a way to Connect Two String in Java. You can Also use +.
	
	}

} 
