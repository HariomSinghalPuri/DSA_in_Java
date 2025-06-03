package Basics_of_Java;

public class Rev_18_Overloading {
	// Like Using Two methods method1 and method2
    // We will use overload method means only using one parameters is enough.
	public static void main(String[] args) {
		int myNum1 = method(29,25);
		double myNum2 = method(4.368454, 6.751542);
		System.out.println("Addition is: " + myNum1);
		System.out.println("Multiply is: " + myNum2);
	}
	static int method(int x, int y) {
		  return x + y;
	}
	static double method(double x, double y) {
		return x * y;
	}
}
