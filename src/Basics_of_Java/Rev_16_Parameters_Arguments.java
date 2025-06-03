package Basics_of_Java;

public class Rev_16_Parameters_Arguments {
	public static void main(String[] args) {

		//Calling to myMethod (Single Parameters)
		myMethod("Amit");
		myMethod("Shubham");
		myMethod("Akash");
		myMethod("Bikram");

		//Calling to myMethod1 (Multiple Parameters)
		myMethod1("Amit", 20);
		myMethod1("Shubham", 21);
		myMethod1("Akash", 19);

	}
	// Use For Single Parameters.
	static void myMethod(String name) {
	    System.out.println(name + " " + "Bhai");
	}
	// Use For Multiple Parameters.
	static void myMethod1(String name, int age) {
		System.out.println(name + " is " + age);
	}
}
