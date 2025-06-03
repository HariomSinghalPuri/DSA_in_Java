package Basics_of_Java;

// Class of 500 Students That we have to Store
// We have to Option 1. Create 500 Variables 
// 2.We use arrays.
public class Rev_14_1D_Array_in_Java {
    // Arrays for integers
	public static void main(String[] args) {
		int [] marks = {2,8,9,5,6};
		System.out.println(marks[4]);
		System.out.println(marks.length); // Length janne ke liye
		for (int element: marks) {
			System.out.println("Marks are:"+element);
		}
		{ // Arrays For String
			String [] Names = {"Hariom" , "Akash" , "Bikram" , "Shubham" };
			for (int i = 0; i < Names.length; i++) {
				  System.out.println(Names[i]); // Print Using For Loop
				}
	     }
		{ // Arrays For String
			String [] Fruits = {"Mangos" , "Banana" , "Watermelon" , "Apple" };
			for (String j : Fruits) {
				  System.out.print(j+" "); // Print Array using For Loop With a short Trick.
				}
	     }
	}
}